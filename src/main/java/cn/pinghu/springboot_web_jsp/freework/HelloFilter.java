package cn.pinghu.springboot_web_jsp.freework;


import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义练习拦截器
 * 过滤器过滤器拦截的是访问的静态资源 或者是请求
 * 拦截器拦截的是接口的请求。
 * @author shenkai
 * @date 2018/12/26
 */
public class HelloFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String name = filterConfig.getInitParameter("name");
        System.out.println("在servlet容器启动之后调用init方法进行初始化filter过滤器"+name);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("dofilter");
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        System.out.println("在关闭服务器的时候调用destroy方法");
    }
}
