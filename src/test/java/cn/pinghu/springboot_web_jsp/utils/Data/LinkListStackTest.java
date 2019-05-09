package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;


/**
 * 链表栈测试类
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkListStackTest {

    private LinkListStack<Integer> linkListStack = new LinkListStack<>();

    @Test
    public void push() {
        for (int i = 0; i < 10; i++) {
            linkListStack.push(i);
        }
        System.out.println("linkListStack = " + linkListStack);
    }

    @Test
    public void pop() {
        for (int i = 0; i < 10; i++) {
            linkListStack.push(i);
        }
        System.out.println("linkListStack = " + linkListStack);
        System.out.println(linkListStack.pop());
        System.out.println(linkListStack.getSize());
    }

    @Test
    public void peek() {
        System.out.println("linkListStack.isEmpty() = " + linkListStack.isEmpty());
        for (int i = 0; i < 10; i++) {
            linkListStack.push(i);
        }
        System.out.println("linkListStack = " + linkListStack);
        System.out.println(linkListStack.peek());
        System.out.println(linkListStack.getSize());
        System.out.println("linkListStack.isEmpty() = " + linkListStack.isEmpty());
    }

    @Test
    public void getSize() {
    }

    @Test
    public void isEmpty() {
    }
}