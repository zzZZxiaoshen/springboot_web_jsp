package cn.pinghu.springboot_web_jsp.utils.Data;

import jdk.nashorn.internal.runtime.FindProperty;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 链表队列测试类
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkListQueueTest {

    private LinkListQueue<Integer> linkListQueue = new LinkListQueue<>();


    @Test
    public void enQueue() {
        for (int i = 0; i < 10; i++) {
            linkListQueue.enQueue(i);
        }
        System.out.println("linkListQueue = " + linkListQueue);
    }

    @Test
    public void deQueue() {
        for (int i = 0; i < 10; i++) {
            linkListQueue.enQueue(i);
        }
        System.out.println("linkListQueue = " + linkListQueue);
        System.out.println(linkListQueue.deQueue());
        System.out.println(linkListQueue.getSize());

    }

    @Test
    public void getFront() {
        System.out.println(linkListQueue.isEmpty());
        for (int i = 0; i < 10; i++) {
            linkListQueue.enQueue(i);
        }
        System.out.println("linkListQueue = " + linkListQueue);
        System.out.println(linkListQueue.getFront());
        System.out.println(linkListQueue.getSize());
        System.out.println(linkListQueue.isEmpty());
    }

    @Test
    public void getSize() {
    }

    @Test
    public void isEmpty() {
    }
}