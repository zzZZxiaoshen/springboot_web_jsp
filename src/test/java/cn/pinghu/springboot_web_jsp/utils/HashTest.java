package cn.pinghu.springboot_web_jsp.utils;

import org.junit.Test;

public class HashTest {

    @Test    public void test(){
        Integer num = 45;
        System.out.println(num.hashCode());
        String st = "adadad";
        System.out.println(st.hashCode());
        Double d = 12.0;
        System.out.println(d.hashCode());
    }

    @Test
    public void test02(){
    }

}
