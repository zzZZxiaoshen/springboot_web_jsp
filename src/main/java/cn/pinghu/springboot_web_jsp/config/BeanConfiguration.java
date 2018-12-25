package cn.pinghu.springboot_web_jsp.config;

import cn.pinghu.springboot_web_jsp.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Student student(){
        return new Student();
    }
}
