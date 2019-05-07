package cn.pinghu.springboot_web_jsp.utils.Data;

import java.util.Arrays;

/**
 * 循环队列
 * @author shenkai
 * @date 2019/5/7
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (T[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue() {
        data = (T[])new Object[10+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enQueue(T element) {
        if ((tail+1)% data.length == 0 ) {
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("dequeue lt size");
        }
        T res = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity()/2);
        }
        return res;
    }

    @Override
    public T getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
