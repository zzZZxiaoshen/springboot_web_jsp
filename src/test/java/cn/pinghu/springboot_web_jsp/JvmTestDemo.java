package cn.pinghu.springboot_web_jsp;

import cn.pinghu.springboot_web_jsp.entity.Test1;
import org.junit.Test;

public class JvmTestDemo {
    @Test
    public void test(){
        Object obj = new Object();
        Test1 demo01 = new Test1();
        System.out.println("obj = " + obj.getClass().getClassLoader());
        System.out.println("------");
//双亲委派代码证明。
        System.out.println("demo01.getClass().getClassLoader().getParent().getParent() = "
                + demo01.getClass().getClassLoader().getParent().getParent());
        System.out.println("demo01.getClass().getClassLoader().getParent() = " + demo01.getClass().getClassLoader().getParent());
        System.out.println("demo01.getClass().getClassLoader() = " + demo01.getClass().getClassLoader());
    }
}
