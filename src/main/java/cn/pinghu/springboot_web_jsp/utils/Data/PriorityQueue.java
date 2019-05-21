package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 优先队列 基于堆数据结构 实现优先队列数据结构
 * @author shenkai
 * @date 2019/5/15
 */
public class PriorityQueue<T extends Comparable> implements Queue<T> {

    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    /**
     * 入队
     * @param element
     */
    @Override
    public void enQueue(T element) {
        maxHeap.add(element);
    }

    /**
    * 出队
    */
    @Override
    public T deQueue() {
        return maxHeap.extractMax();
    }

    /**
    * 查看队列第一个元素
    */
    @Override
    public T getFront() {
        return maxHeap.findMax();
    }

    /**
    * 查看队列中的元素大小
    */
    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    /**
    * 查看队列中是否为空
    */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "maxHeap=" + maxHeap +
                '}';
    }


}
