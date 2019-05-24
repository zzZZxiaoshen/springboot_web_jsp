package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class UnionFind1Test {

    private UnionFind1 unionFind1 = new UnionFind1(100);

    @Test
    public void getSize() {
        System.out.println(unionFind1.getSize());
    }

    @Test
    public void find() {
        System.out.println(unionFind1.find(10));
    }

    @Test
    public void isConnected() {
        System.out.println(unionFind1.isConnected(1, 5));
    }

    @Test
    public void unionElements() {
        System.out.println(unionFind1.isConnected(1, 5));
        unionFind1.unionElements(1,5);
        System.out.println(unionFind1.isConnected(1, 5));
    }
}