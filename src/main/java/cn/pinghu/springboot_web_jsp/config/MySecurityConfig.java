package cn.pinghu.springboot_web_jsp.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.Authenticator;

/**
 * spring Scurity configuration
 * @author shenkai
 * @date 2019/1/1
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
    * 授权
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        // 定制授权规则c
        http.authorizeRequests().mvcMatchers("/").permitAll()
                .antMatchers("/css/**").hasRole("VIP1")
                .antMatchers("/static/**").hasRole("VIP2");
        // 开启登入配置的功能,效果没有登入，没有权限就会来到登陆页面
        http.formLogin().usernameParameter("usernaem")
                .passwordParameter("password").loginPage("userlogin");
        // 1.来到登入页
        // 2.重定向到login/error 表示表示登入失败
        // 3.更多详细规则
        // 4.默认post形式的login代表处理登入
        // 5.一旦定制loginpage；那么loginpage的post请求就是登入

        //开启自动配置注销功能
        http.logout().logoutSuccessUrl("/");// 代表登入以后来到首页
        // 1.访问 /logout 表示用户注销，清空session
        // 2.注销成功会返回/login？out页面

        //开启记住我功能
        http.rememberMe();
    }


    /**
    * 认证
    */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       // super.configure(web);
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP1", "VIP3");

    }
}
