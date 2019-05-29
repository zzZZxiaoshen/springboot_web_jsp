package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author shenkai
 * @date 2019/5/28
 */
public class UnionFind4Test {

    private UnionFind4 unionFind4 = new UnionFind4(100);

    @Test
    public void getSize() {
        System.out.println(unionFind4.getSize());
    }

    @Test
    public void find() {
        System.out.println(unionFind4.find(1));
    }

    @Test
    public void isConnected() {
        System.out.println(unionFind4.isConnected(1, 2));
    }

    @Test
    public void unionElements() {
        unionFind4.unionElements(1, 2);
        System.out.println(unionFind4.isConnected(1, 2));
    }
}