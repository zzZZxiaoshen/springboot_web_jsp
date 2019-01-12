package cn.pinghu.springboot_web_jsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringbootWebJspApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebJspApplication.class, args);
	}

}

