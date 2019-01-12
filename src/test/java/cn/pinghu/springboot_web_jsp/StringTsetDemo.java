package cn.pinghu.springboot_web_jsp;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTsetDemo {

    @Test
    public  void test04() {
        String str = "abd|aaaa";
        String[] split = str.split("|");
        System.out.println(split[0]);
    }

    @Test
    public void test01(){
        String str = "abd|aaaa";
        String name = str.substring(0, str.indexOf("|"));
        System.out.println(name);
    }

    @Test
    public void test03(){
        int i=0;
        if (i > 0) {
            System.out.println("i大于0");
        } else if (i < 0) {
            System.out.println("i小于0");
        } else {
            System.out.println("i等于0");
        }
    }
}
