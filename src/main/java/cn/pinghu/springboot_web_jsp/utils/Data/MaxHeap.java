package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 最大堆
 * @author shenkai
 * @date 2019/5/15
 */
public class MaxHeap<T extends Comparable> {

    private Array<T> data;

    public MaxHeap() {
        this.data = new Array();
    }
    // 返回堆中的元素个数
    public int getSize() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    public int getParentNode(int index) {
        int res = (index - 1) / 2;
        return res;
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int getLeftChildNode(int index) {
        return 2 * index + 1;
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int getRightChildNode(int index) {
        return 2 * index + 2;
    }

    /**
     * 向堆中添加元素
     */
    public void add(T element) {
        data.addLast(element);
        siftUp(data.getSize() - 1);
    }

    /**
     *  提升或者改变节点索引
     * @param index
     */
    private void siftUp(int index) {
        while (index > 0 && data.get(getParentNode(index)).compareTo(data.get(index)) < 0) {
            // 交换对应索引的元素内容
            data.swap(getParentNode(index), index);
            // 改变索引 对应的内容之后 改变index循环判断当前索引内容是否大于父节点
            // 注意因为数据是动态的。
            index = getParentNode(index);
        }
    }


    // 看堆中的最大元素
    public T findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public T extractMax(){
        T max = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    /**
     * 下降或者改变元素节点索引
     * @param index 当前索引
     *    注意while用法新理解 加强理解与运用
     *              中断条件在循环语句中使用break 关键字跳出循环。
     *              并没有设置标记 在while中进行结束或者在初始化一个变量做标记
     */
    public void siftDown(int index) {
        while (getLeftChildNode(index) < data.getSize()) {
            int j = getLeftChildNode(index);
            if (j < data.getSize() - 1 && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j++;
            }
            if (data.get(index).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(index, j);
            index = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public T replace(T element) {
        T max = findMax();
        data.set(0,element);
        siftDown(0);
        return max;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }
}
