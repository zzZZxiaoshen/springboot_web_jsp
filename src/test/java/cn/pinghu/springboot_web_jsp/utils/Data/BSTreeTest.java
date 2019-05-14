package cn.pinghu.springboot_web_jsp.utils.Data;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTreeTest {

    private BSTree<Integer> bsTree = new BSTree<>();

    {
        int[] arr = {5, 2, 7, 3, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            bsTree.add(arr[i]);
        }
    }

    @Test
    public void add() {
        System.out.println(bsTree);
    }

    @Test
    public void contain() {
        System.out.println(bsTree.contain(10));
    }

    @Test
    public void preTranserve(){
        System.out.println(bsTree);
        bsTree.preTranserve();
    }

    @Test
    public void interTranserve(){
        System.out.println(bsTree);
        bsTree.interTranserve();
    }

    @Test
    public void postTranserve(){
        System.out.println(bsTree);
        System.out.println("\n");
        bsTree.preTranserve();
        System.out.println("\n");
        bsTree.interTranserve();
        System.out.println("\n");
        bsTree.postTranserve();
    }

    @Test
    public void transerve(){
        bsTree.transerve();
    }

    @Test
    public void breathTranserve(){
        bsTree.transerve();
        System.out.println("/n");
        bsTree.breathTranserve();

    }

    @Test
    public void removeMinElement() {
        System.out.println(bsTree.removeMinElement());
        System.out.println("\n");
        bsTree.transerve();
    }

    @Test
    public void removeMaxElement() {
        System.out.println(bsTree.removeMaxElement());
        System.out.println("\n");
        bsTree.transerve();
    }

    @Test
    public void remove() {
        bsTree.remove(9);
        bsTree.transerve();
    }

    @Test
    public void getSize() {
        bsTree.remove(9);
        bsTree.remove(7);
        System.out.println(bsTree.getSize());
    }

    @Test
    public void isEmpty() {
        System.out.println(bsTree.isEmpty());
    }

}