package cn.pinghu.springboot_web_jsp.utils.Data;

import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import static org.junit.Assert.*;

public class LinkListQueue2Test {

    private LinkListQueue2<Integer> linkListQueue2 = new LinkListQueue2();

    {
        for (int i = 0; i < 10; i++) {
            linkListQueue2.enQueue(i);
        }
    }

    @Test
    public void enQueue() {
        System.out.println("linkListQueue2 = " + linkListQueue2);
    }

    @Test
    public void deQueue() {
        System.out.println(linkListQueue2.deQueue());
        System.out.println(linkListQueue2);
    }

    @Test
    public void getFront() {
        System.out.println(linkListQueue2.getFront());
        System.out.println(linkListQueue2);
    }

    @Test
    public void getSize() {
        System.out.println(linkListQueue2.getSize());

    }

    @Test
    public void isEmpty() {
        System.out.println(linkListQueue2.isEmpty());
    }
}