package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFind3Test {

    private UnionFind3 unionFind3 = new UnionFind3(100);

    @Test
    public void getSize() {
        System.out.println(unionFind3.getSize());
    }

    @Test
    public void find() {
        System.out.println(unionFind3.find(3));
    }

    @Test
    public void isConnected() {
        System.out.println(unionFind3.isConnected(1, 2));
    }

    @Test
    public void unionElements() {
        unionFind3.unionElements(1,2);
        System.out.println(unionFind3.isConnected(1, 2));
    }
}