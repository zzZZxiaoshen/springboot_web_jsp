package cn.pinghu.springboot_web_jsp.utils.Data;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;


public class LinkListDummyHeadTest {

    private LinkListDummyHead<Integer> linkListDummyHead = new LinkListDummyHead();

    @Test
    public void getSize() {
        System.out.println(linkListDummyHead.getSize());
    }

    @Test
    public void isEmpty() {
        System.out.println(linkListDummyHead.isEmpty());
    }

    @Test
    public void addFirst() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);

    }

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.set(50, 3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println("linkListDummyHead.contain(50) = " + linkListDummyHead.contain(50));
        System.out.println(linkListDummyHead.get(3));
    }

    @Test
    public void addLast() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.addLast(1000);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
    }
}