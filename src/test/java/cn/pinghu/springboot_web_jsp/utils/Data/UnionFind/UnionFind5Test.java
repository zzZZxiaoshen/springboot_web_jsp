package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnionFind5Test {

    private UnionFind5 unionFind5 = new UnionFind5(100);

    @Test
    public void getSize() {
    }

    @Test
    public void find() {
    }

    @Test
    public void isConnected() {
    }

    @Test
    public void unionElements() {
        unionFind5.unionElements(1, 2);
        System.out.println(unionFind5.isConnected(1, 2));

    }
}