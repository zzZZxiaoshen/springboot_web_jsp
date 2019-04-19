package cn.pinghu.springboot_web_jsp;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test05(){
        long sum = (long) (100000 * 0.1);
        long all = sum * 30;
        System.out.println("all = " + all);
    }
    @Test
    public void test06(){
        int a = 1;
        long  b  =2l;
        int d = 1;
        int c = a + (int) b;
    }

    @Test
    public void test07(){
        String apth = "1111.jsp";
        String substring = apth.substring(apth.lastIndexOf("."));
        System.out.println("substring = " + substring);
        File file2 = new File("E:\\demo", "a.txt");
        System.out.println("file2 = " + file2);
    }

    /**
     * 1.编程. 已知字符串：”this is a test of java”.
     * 按要求执行以下操作：
     * (1) 统计该字符串中字母s出现的次数
     * (2) 取出子字符串”test”
     * (3) 将本字符串复制到一个字符数组Char[] str中.
     * (4) 将字符串中每个单词的第一个字母变成大写， 输出到控制台。
     * (5) 用两种方式实现该字符串的倒叙输出。(用StringBuffer和for循环方式分别实现)
     * (6) 将本字符串转换成一个字符串数组，要求每个数组元素都是一个有意义的额英文单词,并输出到控制台
     */
    public static final String STRING = "this is a test of java";

    //统计该字符串中字母s出现的次数
    @Test
    public void test08() {
        char[] chars = STRING.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (aChar == 's') {
                index += 1;
            }
        }
        System.out.println("index= "+index);
    }

    // 将字符串中每个单词的第一个字母变成大写， 输出到控制台
    @Test
    public void test09() {
        List<String> strings = Splitter.on(" ").splitToList(STRING);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            char c = s.charAt(0);
            char toUpperCase = Character.toUpperCase(c);
            String substring = s.substring(1);
            System.out.println(" string1= " +toUpperCase+ substring);
        }
    }

    // 取出子字符串”test”
    @Test
    public void test10() {
        String substring = STRING.substring(STRING.indexOf("t",1) , STRING.lastIndexOf("t")+ 1);
        System.out.println("substring = " + substring);
    }

}
