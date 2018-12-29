package cn.pinghu.springboot_web_jsp.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanLife  implements InitializingBean, DisposableBean {
    private String name;

    public BeanLife() {
        System.out.println("构造bean");
    }

    public BeanLife(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化方法");
    }

}
