package cn.pinghu.springboot_web_jsp;

import cn.pinghu.springboot_web_jsp.utils.Data.Array;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;

/**
 * 数组结构测试 类
 * @author shenkai
 * @date 2019/5/5
 */
public class DataTest {

    @Test
    public void test01(){
        Array array = new Array();
        for (int i = 0; i < 10; i++) {
         array.add(i,i);
        }
        System.out.println("array = " + array);
        array.add(1, 100);
        System.out.println("array = " + array);
        System.out.println(array.get(1));
        System.out.println(array.find(100));
        System.out.println(array.containElement(1000));
    }

}
