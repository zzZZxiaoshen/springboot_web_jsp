package cn.pinghu.springboot_web_jsp.utils.Data;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


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
    public void topKFrequent() {
        int[] nums = {3,4,1, 1, 1, 5,5, };
        int k = 2;
        topKFrequent(nums, k);
    }



    /**
    * 给定非空的整数数组，返回k个最常见的元素。
    */
    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.getSize() < k)
                pq.enQueue(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.getFront().freq){
                pq.deQueue();
                pq.enQueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.deQueue().e);
        return res;
    }


}