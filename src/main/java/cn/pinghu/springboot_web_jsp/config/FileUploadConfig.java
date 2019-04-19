package cn.pinghu.springboot_web_jsp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  原生加载组件配置类
 *
 *  新理解 在springboot框架下 个人认为分项目动态配置参数与其他各种框架自生的配置
 *      所以我们可以将框架其自生的整合spring之后需要怎么样的功能 这就是属于框架自生的配置
 *      ，然后具体的配置参数在项目的配置文件中进行配置 以便于进行解耦
 *    在原生xml配置情况下 ，整合的其他框架的配置就在xml中进行配置
 *                          具体的配置参数在项目的propertise属性文件中进行配置。
 * @author shenkai
 * @date 2019/3/8
 */
@Component
@ConfigurationProperties("fileUpload")
@Data
public class FileUploadConfig {

    /**
     * 允许上的文件格式
     */
    private String exts;

    /**
    * 允许单个上传的文件最大限制
    */
    private String fileMaxSize;

    /**
    * 允许所有文件上传的总共大小
    */
    private String   totalFileMaxSize;

}
