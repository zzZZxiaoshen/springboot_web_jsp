package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

public class LinkListTest {

    private LinkListRealHead<Integer> linkList = new LinkListRealHead();

    @Test
    public void getSize() {
        System.out.println(linkList.getSize());
    }

    @Test
    public void isEmpty() {
        System.out.println(linkList.isEmpty());
    }

    @Test
    public void addFirst() {
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
        }
        System.out.println(linkList.toString());
        System.out.println(linkList.isEmpty());
        System.out.println(linkList.getSize());
    }

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i);
        }
        linkList.add(100,3);
        System.out.println(linkList.toString());
        System.out.println(linkList.isEmpty());
        System.out.println(linkList.getSize());
    }

    @Test
    public void addLast() {
    }


}