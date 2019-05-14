package cn.pinghu.springboot_web_jsp.utils.Data;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

public class BstSetTest {

    private BstSet<Integer> bstSet = new BstSet();

    {
        int[] arr = {5, 2, 7, 3, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            bstSet.add(arr[i]);
        }
    }

    @Test
    public void add() {
        System.out.println(bstSet.toString());
    }

    @Test
    public void contain() {
        System.out.println(bstSet.contain(19));
    }

    @Test
    public void getSize() {
        System.out.println(bstSet.getSize());
    }

    @Test
    public void isEmpty() {
        System.out.println(bstSet.isEmpty());
    }

    @Test
    public void remove() {
        bstSet.remove(7);
        System.out.println(bstSet.getSize());
    }

    @Test
    public void uniqueMorseRepresentations() {
        String[] strs = {"c", "b", "v"};
        System.out.println(bstSet.uniqueMorseRepresentations(strs));
    }

}