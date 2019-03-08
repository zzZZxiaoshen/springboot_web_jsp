package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.config.FileUploadConfig;
import cn.pinghu.springboot_web_jsp.dto.FileUploadBean;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shenkai
 * @date 2019/3/8
 */
@Service
public class FileUpLoadService {

   public static final  String path = System.currentTimeMillis() + ".jpg";

    @Autowired
    private FileUploadConfig fileUploadConfig;

    /**
     *  下载文件
     * @param fileItems
     */
    public void uploadFile(List<FileItem> fileItems) throws FileUploadException, IOException {
        Map<String, FileItem> uploadFiles = new HashMap<>();
        //1. 构建 FileUploadBean 的集合, 同时填充 uploadFiles
        List<FileUploadBean> fileUploadBeans = buildUploadBean(fileItems,uploadFiles);
        //2. 校验扩展名:
        validateName(uploadFiles);
        //3. 校验文件的大小: 在解析时, 已经校验了, 我们只需要通过异常得到结果.
        //4. 进行文件的上传操作.（注意这步是保存真正的文件资源。）
        upload(fileUploadBeans);
        //5. 把上传的信息保存到数据库中（注意这步的目的是为了保存在数据库的文件信息，而不是真正的文件）。
        //6. 删除临时文件夹的临时文件

    }

    /**
    *  将文件下载到本地
    */
    private void upload(List<FileUploadBean> fileUploadBeans) throws IOException {
        for (FileUploadBean fileUploadBean : fileUploadBeans) {
            FileItem fileItem = fileUploadBean.getFileItem();
            // 将上传的文件保存到本地
            saveFileUpload(fileItem);
        }
    }

    /**
    * 将上传的文件保存到本地
    */
    private void saveFileUpload(FileItem fileItem) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStream fin = fileItem.getInputStream();
        FileOutputStream ots = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fin.read(bytes)) != -1){
            ots.write(bytes, 0, len);
        }
        fin.close();
        ots.close();
    }

    /**
    * 校验扩展名合法性
    */
    private void validateName(Map<String, FileItem> uploadFiles) throws FileUploadException {
        for (String fileName : uploadFiles.keySet()) {
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            String exts = fileUploadConfig.getExts();
            List<String> list = CollectionUtils.arrayToList(exts.split(","));
            if (!list.contains(prefix)) {
                throw new FileUploadException("格式不合法");
            }
        }
    }

    /**
    * 封装fileULoadBean 和填充 uploadFiles 集合
    */
    private List<FileUploadBean> buildUploadBean(List<FileItem> fileItems, Map<String, FileItem> uploadFiles) {
        List<FileUploadBean> fileUploadBeans = new ArrayList<>();
        for (FileItem fileItem : fileItems) {
            uploadFiles.put(fileItem.getFieldName(), fileItem);
            FileUploadBean fileUploadBean = new FileUploadBean();
            fileUploadBean.setFileName(fileItem.getFieldName());
            fileUploadBean.setDesc("utf-8");
            fileUploadBean.setFileItem(fileItem);
            fileUploadBeans.add(fileUploadBean);
        }
        return fileUploadBeans;
    }
}
