package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;


public class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    {
        int[] arr = {5, 2, 7, 3, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.enQueue(arr[i]);
        }
    }
    @Test
    public void enQueue() {
        System.out.println(priorityQueue.toString());
    }

    @Test
    public void deQueue() {
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.deQueue());
        System.out.println(priorityQueue.getSize());
    }

    @Test
    public void getFront() {
        System.out.println(priorityQueue.getFront());
        System.out.println(priorityQueue.getSize());
    }

    @Test
    public void getSize() {
    }

    @Test
    public void isEmpty() {

    }
}