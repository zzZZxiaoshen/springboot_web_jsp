package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 堆测试类
 * @author shenkai
 * @date 2019/5/15
 */
public class MaxHeapTest {

    private MaxHeap<Integer> maxHeap = new MaxHeap<>();
    {
        int[] arr = {5, 2, 7, 3, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }
    }
    @Test
    public void getSize() {
        System.out.println(maxHeap.getSize());
    }

    @Test
    public void isEmpty() {
        System.out.println(maxHeap.isEmpty());
        System.out.println(maxHeap.toString());
    }

    @Test
    public void getParentNode() {
        System.out.println(maxHeap.getParentNode(3));
        System.out.println(maxHeap.getLeftChildNode(0));
        System.out.println(maxHeap.getRightChildNode(0));

    }

    @Test
    public void findMax() {
        System.out.println(maxHeap.findMax());
        System.out.println(maxHeap.getSize());
    }

    @Test
    public void extractMax() {
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.getSize());
    }
}