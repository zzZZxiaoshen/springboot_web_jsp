package cn.pinghu.springboot_web_jsp.config;

import cn.pinghu.springboot_web_jsp.entity.Student;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfiguration {

    @Bean
    public Student student(){
        return new Student();
    }


    /**
     * 构建 ServletFileUpload 对象
     * 从配置文件中读取了部分属性, 用户设置约束.
     * 该方法代码来源于文档.
     * @return
     */
    @Bean
    public ServletFileUpload getServletFileUpload(FileUploadConfig fileUploadConfig) {

        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(1024 * 500);
        File tempDirectory = new File(fileUploadConfig.getExts());
        factory.setRepository(tempDirectory);

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setSizeMax(Integer.parseInt(fileUploadConfig.getTotalFileMaxSize()));
        upload.setFileSizeMax(Integer.parseInt(fileUploadConfig.getFileMaxSize()));
        return upload;
    }


}
