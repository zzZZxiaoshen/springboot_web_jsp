package cn.pinghu.springboot_web_jsp.utils.Data;

import cn.afterturn.easypoi.cache.manager.IFileLoader;

import java.util.Arrays;

/**
 * 线段树 数据结构
 * @author shenkai
 * @date 2019/5/16
 */
public class SegmentTree<T > {

    private T[] data;
    private T[] tree;
    private Merge<T> merger;

    public SegmentTree(T[] arr, Merge merge) {
        this.merger = merge;
        data = (T[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (T[]) new Object[4 * arr.length];
        // 创建线段树节点
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
    * 获取元素大小
    */
    public int getSize() {
        return data.length;
    }

    /**
     * 获取对应索引处的元素
     */
    public T get(int index) {
        if (index > getSize()) {
            throw new IllegalArgumentException("get index erro");
        }
        return data[index];
    }

    /**
    * 在treeIndex的位置创建表示区间[l...r]的线段树
    */
    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int mid = (l + r) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    /**
     * 返回区间[queryL, queryR]的值
     */
    public T query(int queryL, int queryR) {
        if (queryL < 0 || queryR > data.length - 1) {
            throw new IllegalArgumentException(" query index out erro");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
    * 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    */
    private T query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = (l + r) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        if(queryL >= mid + 1)
            return query(rightIndex, mid + 1, r, queryL, queryR);
        else if(queryR <= mid)
            return query(leftIndex, l, mid, queryL, queryR);
        T leftResult = query(leftIndex, l, mid, queryL, mid);
        T rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }


    // 将index位置的值，更新为e
    public void set(int index, T e) throws IllegalAccessException {
        if (index < 0 || index >data.length)
            throw new IllegalAccessException("set erro");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, T e){
        if (l == r) {
            tree[treeIndex] = e;
        }
        int mid = (l + r) / 2;
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (index >= mid + 1) {
            set(rightIndex,mid+1,r,index,e);
        } else if (index <= mid) {
            set(leftIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }


    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }

    @Override
    public String toString() {
        return "SegmentTree{" +
                "data=" + Arrays.toString(data) +
                ", tree=" + Arrays.toString(tree) +
                ", merger=" + merger +
                '}';
    }

}
