package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 数组队列
 * @author shenkai
 * @date 2019/5/7
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> array;
    private int size;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
        size = 0;
    }

    public ArrayQueue() {
        array = new Array<>();
        size = 0;
    }

    /**
    * 入列
    */
    @Override
    public void enQueue(T element) {
        array.addLast(element);
    }

    /**
    * 出列
    */
    @Override
    public T deQueue() {
        return  array.removeFirst();
    }

    /**
    * 查看队列第一个元素
    */
    @Override
    public T getFront() {
        return  array.get(0);
    }

    /**
    * 获取队列中得元素个数
    */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
    * 判断队列是否为空
    */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }


    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                ", size=" + size +
                '}';
    }
}
