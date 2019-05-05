package cn.pinghu.springboot_web_jsp.utils.Data;

import java.util.Arrays;

/**
 * 自定义数组数据结构（线性结构）
 * @author shenkai
 * @date 2019/5/5
 */
public class Array   {

    private int[] data;
    private int size;

    public Array(int capacity){
        this.data = new int[capacity];
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
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     *  修改
     */
    public void set(int index,int element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = element;
    }

    /**
     * 向数组首位置 插入元素
     * @param element 元素
     */
    public void  addFirst(int element) {
        add(0,element);
    }

    /**
     * 向元素的末尾 插入元素
     * @param element 元素
     */
    public void  addLast(int element) {
        add(size,element);
    }
    /**
     * 向数组中添加元素
     * @param index 添加元素的位置
     * @param element 元素
     */
    public void  add(int index,int element) {
        if (index >data.length){
            throw new RuntimeException("add Element erro");
        }
        if (index > size || index < 0) {
            throw new RuntimeException("add Element erro");
        }
        for (int i = size - 1; i >= size; i--) {
            data[i + 1] = data[1];
        }
        data[index] = element;
        size++;
    }

    /**
     * 包含
     * @return 是否包含
     */
    public boolean containElement(int element){
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
    public int find(int element) {
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
    public int removeElement(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }
    /**
     * 删除第一个元素
     * @return 删除第一个元素并且返回
     */
    public int  removeFirst(int index) {
        return removeElement(0);
    }

    /**
     * 删除最后一个元素
     * @return 删除并且返回最后一个元素
     */
    public int  removeLast(int index) {
        return removeElement(size-1);
    }

    /**
     * 从数组中删除指定元素
     * @param element 指定元素
     */
    public void remove(int element) {
        int index = find(element);
        if (index !=-1) {
          removeElement(index);
        }
    }


    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

}
