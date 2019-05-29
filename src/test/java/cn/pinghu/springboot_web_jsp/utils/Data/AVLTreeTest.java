package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {

    private AVLTree<Integer, Integer> avlTree = new AVLTree<>();
    {
        for (int i = 1; i < 10; i++) {
            avlTree.add(i, i);
        }
    }

    @Test
    public void getSize() {

    }

    @Test
    public void contain() {
        System.out.println(avlTree.contain(1));
        System.out.println(avlTree.getSize());
        System.out.println(avlTree.toString());

        System.out.println(avlTree.isBanlanceAvl());
        System.out.println(avlTree.isBST());
    }

    @Test
    public void add() {
    }

    @Test
    public void removeMin() {
        System.out.println(avlTree.removeMax());
        System.out.println(avlTree.getSize());
    }

    @Test
    public void removeMax() {
        System.out.println(avlTree.removeMin());
        System.out.println(avlTree.getSize());
    }

    @Test
    public void remove() {
        System.out.println(avlTree.remove(2));
        System.out.println(avlTree.getSize());
    }
}