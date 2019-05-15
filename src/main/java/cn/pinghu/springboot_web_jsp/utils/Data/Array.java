package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 自定义数组数据结构（线性结构）
 * @author shenkai
 * @date 2019/5/5
 */
public class Array<T>  {

    private T[] data;
    private int size;

    public Array(int capacity){
        this.data = (T[])new Object[capacity];
        this.size = 0;
    }

    public Array(){
        this(10);
    }


    /**
     * 获取数组容量大小
     * @return  数组容量大小
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     * @return 数组中的元素个数
     */
    public int getSize(){
        return size;
    }
    /**
     *  判断数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取索引处的元素
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     *  修改
     */
    public void set(int index,T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = element;
    }

    /**
     * 向数组首位置 插入元素
     * @param element 元素
     */
    public void  addFirst(T element) {
        add(0,element);
    }

    /**
     * 向元素的末尾 插入元素
     * @param element 元素
     */
    public void  addLast(T element) {
        add(size,element);
    }
    /**
     * 向数组中添加元素
     * @param index 添加元素的位置
     * @param element 元素
     */
    public void  add(int index,T element) {
        if (index >data.length){
            throw new RuntimeException("add Element erro");
        }
        if (index > size || index < 0) {
            throw new RuntimeException("add Element erro");
        }
        if (size == data.length) {
            resize(data.length*2);
        }
        for (int i = size - 1; i >= size; i--) {
            data[i + 1] = data[1];
        }
        data[index] = element;
        size++;
    }

    private void resize(int capacity) {
       T[] newArray= (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i ];
        }
        this.data = newArray;
    }

    /**
     * 包含
     * @return 是否包含
     */
    public boolean containElement(T element){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * 搜索
     * @param element 元素
     * @return 元素对应的索引 -1 为没有对应的元素
     */
    public int find(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中的元素
     * @return 删除元素
     */
    public T removeElement(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        T ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length/4) {
            resize(data.length/2);
        }
        return ret;
    }
    /**
     * 删除最后一个元素
     * @return 删除并且返回最后一个元素
     */
    public T  removeLast() {
        return removeElement(size-1);
    }

    /**
     * 删除第一个元素
     * @return 删除第一个元素并且返回
     */
    public T  removeFirst() {
        return removeElement(0);
    }

    /**
     * 从数组中删除指定元素
     * @param element 指定元素
     */
    public void remove(T element) {
        int index = find(element);
        if (index !=-1) {
          removeElement(index);
        }
    }


    public void swap(int i, int j){

        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + java.util.Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

}
