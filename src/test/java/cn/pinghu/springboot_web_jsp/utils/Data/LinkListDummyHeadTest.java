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

    @Test
    public void get() {

    }

    @Test
    public void getFirst() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println(linkListDummyHead.getFirst());
    }

    @Test
    public void getLast() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println(linkListDummyHead.getLast());
    }

    @Test
    public void set() {

    }

    @Test
    public void contain() {
    }

    @Test
    public void remove() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println(linkListDummyHead.remove(1));
        System.out.println(linkListDummyHead.getSize());
    }

    @Test
    public void removeFirst() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println(linkListDummyHead.removeFirst());
        System.out.println(linkListDummyHead.getSize());
    }

    @Test
    public void removeLast() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println(linkListDummyHead.removeLast());
        System.out.println(linkListDummyHead.getSize());
    }

    @Test
    public void removeEelement() {
        for (int i = 0; i < 10; i++) {
            linkListDummyHead.addFirst(i);
        }
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        linkListDummyHead.add(100,3);
        System.out.println("linkListDummyHead = " + linkListDummyHead);
        System.out.println(linkListDummyHead.removeEelement(19));
        System.out.println(linkListDummyHead.getSize());
    }

    @Test
    public void toString1() {
    }
}