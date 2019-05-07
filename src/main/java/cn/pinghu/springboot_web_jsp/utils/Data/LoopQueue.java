package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 循环队列
 * @author shenkai
 * @date 2019/5/7
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front,tail;
    private int size;

    @Override
    public void enQueue(T element) {

    }

    @Override
    public T deQueue() {
        return null;
    }

    @Override
    public T getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
