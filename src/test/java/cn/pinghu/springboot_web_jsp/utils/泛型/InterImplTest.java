package cn.pinghu.springboot_web_jsp.utils.泛型;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterImplTest {

    @Test
    public void show() {
        Inter<String> inter1 = new InterImpl();
        inter1.show("11");

        Inter<Integer> inter2 = new InterImpl();
        inter2.show(1);
    }

    @Test
    public void show2() {
        Inter<String> inter1 = new InterImpl1();
        inter1.show("");

    }

    @Test
    public void show3() {
        Inter<String> inter1 = new InterImpl2();
        inter1.show("");

    }
}