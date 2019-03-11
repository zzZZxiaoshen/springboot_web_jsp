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

   public static final  String path ="\\static\\img\\";

    @Autowired
    private FileUploadConfig fileUploadConfig;

    /**
     *  下载文件
     * @param fileItems
     * @param realPath
     */
    public void uploadFile(List<FileItem> fileItems, String realPath) throws FileUploadException, IOException {
        // 初始化一个容器目的是作为一个下载功能的入参这样更加有效的接耦以及扩展该方法的功能
        Map<String, FileItem> uploadFiles = new HashMap<>();

       //1. 构建 FileUploadBean 的集合, 同时填充 uploadFiles
        List<FileUploadBean> fileUploadBeans = buildUploadBean(fileItems,uploadFiles,realPath);
        //2. 校验扩展名:
        validateName(fileUploadBeans);
        //3. 校验文件的大小: 在解析时, 已经校验了, 我们只需要通过异常得到结果.
        //4. 进行文件的上传操作.（注意这步是保存真正的文件资源。）
        upload(uploadFiles);
        //5. 把上传的信息保存到数据库中（注意这步的目的是为了保存在数据库的文件信息，而不是真正的文件）。
        //  fileUploadSave(fileUploadBeans);
        //6. 删除临时文件夹的临时文件

    }

    /**
    *  将文件下载到本地 将接收的入参设置为Map<String, FileItem> 的
     *  目的是为了将该文件下载的功能方法更加的解耦，更加的易于扩展
    */
    private void upload(Map<String, FileItem> fileUploadBeans) throws IOException {
        for (String filePath : fileUploadBeans.keySet()) {
            FileItem fileItem = fileUploadBeans.get(filePath);
            // 将上传的文件保存到本地
            saveFileUpload(filePath,fileItem);
        }
    }

    /**
    * 将上传的文件保存到本地
    */
    private void saveFileUpload(String filePath,FileItem fileItem) throws IOException {
        File file = new File(filePath);
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
    private void validateName(List<FileUploadBean> fileUploadBeans) throws FileUploadException {
        for (FileUploadBean fileUploadBean : fileUploadBeans) {
            String fileName = fileUploadBean.getFileName();
            String prefix =fileName.substring(fileName.lastIndexOf("."));
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
    private List<FileUploadBean> buildUploadBean(List<FileItem> fileItems
            , Map<String, FileItem> uploadFiles,String realPath) {
        List<FileUploadBean> fileUploadBeans = new ArrayList<>();

        for (FileItem fileItem : fileItems) {
            FileUploadBean fileUploadBean = new FileUploadBean();
            fileUploadBean.setFileName(fileItem.getFieldName());
            fileUploadBean.setFilePath(getFilePath(fileItem,realPath));
            fileUploadBean.setDesc("utf-8");
            fileUploadBean.setFileItem(fileItem);

            fileUploadBeans.add(fileUploadBean);
            uploadFiles.put(fileUploadBean.getFilePath(), fileItem);
        }
        return fileUploadBeans;
    }

    /**
    * 得到文件下载路径
     * @param fileItem
     * @param realPath
     */
    private String getFilePath(FileItem fileItem, String realPath) {
        String fieldName = fileItem.getFieldName();
        String prefix = fieldName.substring(fieldName.lastIndexOf("."));
        return realPath +path +System.currentTimeMillis()+prefix;
    }
}
