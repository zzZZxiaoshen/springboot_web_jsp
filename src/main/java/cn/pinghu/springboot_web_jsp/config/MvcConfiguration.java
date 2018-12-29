package cn.pinghu.springboot_web_jsp.config;

import cn.pinghu.springboot_web_jsp.freework.convers.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * springMvc配置扩展类
 * @author shenkai
 * @date 2018/12/28
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    /**
    * 扩展类型转换器
    */
    @Bean
    public DateConverter converter() {
        return new DateConverter();
    }

}
