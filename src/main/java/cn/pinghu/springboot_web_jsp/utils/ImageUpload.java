package cn.pinghu.springboot_web_jsp.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 图片上传调用服务
 * @author shenkai
 * @date 2018/12/28
 */
public class ImageUpload {
    private final Logger LOGGER = LogManager.getLogger(ImageUpload.class);

    String accessKey = "your access key";
    String secretKey = "your secret key";
    String bucket = "your bucket name";

    /**
     * 保存图片
     * @param file 图片文件
     * @return 地址字符串
     */
    public String save(MultipartFile file) {
        try {
            return  this.saveImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    /**
    * 上传图片
    * @param bytes 图片字节数组
    * @return 图片地址
    */
    private String saveImage(byte[] bytes) {
        String upToken = getUploadToken();
        try {
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            Response response = uploadManager.put(bytes, null, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.toString(), DefaultPutRet.class);
            return putRet.toString();
        } catch (QiniuException e) {
            LOGGER.error(e.getMessage(), e);
            return StringUtils.EMPTY;
        }
    }

    /**
    * 获取下载的token
    * @return token参数
    */
    private String getUploadToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucket);
    }


}
