package cn.pinghu.springboot_web_jsp.freework;


import javax.servlet.*;
import java.io.IOException;

/**
 *  权限过滤器
 * @author shenkai
 * @date 2018/12/26
 */
public class AuthorityFileter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("tocmat启动条用过滤器的init方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
