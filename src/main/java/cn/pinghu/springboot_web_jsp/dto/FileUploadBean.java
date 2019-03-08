package cn.pinghu.springboot_web_jsp.dto;

import lombok.Data;
import org.apache.commons.fileupload.FileItem;

/**
 * 文件 下载bean封装类
 *
 * @author shenkai
 * @date 2019/3/8
 */
@Data
public class FileUploadBean {

    /**
    * 文件名字
    */
    String fileName;

    /**
     * 文件描述
     */
    String desc;

    /**
    * 文件
    */
    FileItem fileItem;
}
