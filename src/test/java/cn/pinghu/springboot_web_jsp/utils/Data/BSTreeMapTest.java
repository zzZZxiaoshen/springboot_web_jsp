package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTreeMapTest {

    private BSTreeMap<Integer, Integer> bsTreeMap = new BSTreeMap<>();

    {
        int[] arr = {5, 2, 7, 3, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            bsTreeMap.add(arr[i],arr[i]);
        }
    }

    @Test
    public void getSize() {
        System.out.println(bsTreeMap.getSize());
        System.out.println(bsTreeMap.toString());
    }

    @Test
    public void isEmpty() {
        System.out.println(bsTreeMap.isEmpty());
    }

    @Test
    public void contains() {
        System.out.println(bsTreeMap.contains(10));
    }

    @Test
    public void get() {
        System.out.println(bsTreeMap.get(10));
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
        System.out.println(bsTreeMap.remove(5));
        System.out.println(bsTreeMap.toString());
        System.out.println(bsTreeMap.getSize());
    }

    @Test
    public void minValue() {
        System.out.println(bsTreeMap.minValue());
    }

    @Test
    public void maxValue() {

    }

    @Test
    public void set() {
        bsTreeMap.set( 7,1000);
        System.out.println(bsTreeMap.toString());
    }

}