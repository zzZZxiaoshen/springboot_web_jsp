package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * linkListMap测试类
 * @author shenkai
 * @date 2019/5/14
 */
public class LinkListMapTest {

    private LinkListMap<Integer, Integer> map = new LinkListMap<>();

    {
        for (int i = 0; i < 100; i++) {
            map.add(i,i);
        }
    }

    @Test
    public void getSize() {
        System.out.println(map.getSize());
        System.out.println(map);
    }

    @Test
    public void isEmpty() {
        System.out.println(map.isEmpty());
    }

    @Test
    public void get() {
        System.out.println(map.get(2));
    }

    @Test
    public void contains() {
        System.out.println(map.contains(1));
        System.out.println(map.contains(4));
    }

    @Test
    public void getNode() {
        System.out.println("map.getNode(1) = " + map.getNode(1));
    }

    @Test
    public void add() {
    }

    @Test
    public void set() {
        map.set(2,4);
        System.out.println("map = " + map);
    }

    @Test
    public void remove() {
        map.remove(2);
        System.out.println(map.getSize());
        System.out.println(map.toString());
    }

}