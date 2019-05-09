package cn.pinghu.springboot_web_jsp.utils.Data;

import com.sun.corba.se.impl.orbutil.LogKeywords;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkListTest {

    private LinkList<Integer> linkList = new LinkList();

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
        linkList.add(100,0);
        System.out.println(linkList.toString());
        System.out.println(linkList.isEmpty());
        System.out.println(linkList.getSize());
    }

    @Test
    public void addLast() {
    }


}