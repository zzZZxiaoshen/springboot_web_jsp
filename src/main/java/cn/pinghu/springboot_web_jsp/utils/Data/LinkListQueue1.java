package cn.pinghu.springboot_web_jsp.utils.Data;


/**
 * 链表栈
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkListQueue1<T> implements Queue<T> {

    private LinkListDummyHead<T> linkListDummyHead;

    public LinkListQueue1() {
        this.linkListDummyHead = new LinkListDummyHead();
    }

    /**
     * 入队
     * @param element 元素
     */
    @Override
    public void enQueue(T element) {
        linkListDummyHead.addLast(element);
    }

    /**
     * 出队
     * @return 出队元素
     */
    @Override
    public T deQueue() {
        return linkListDummyHead.removeFirst();
    }


    /**
     * 查看队列的第一个元素
     * @return 队列的第一个元素
     */
    @Override
    public T getFront() {
        return linkListDummyHead.getFirst();
    }

    /**
     * 获取队列的元素数量
     * @return 队列中的元素数量
     */
    @Override
    public int getSize() {
        return linkListDummyHead.getSize();
    }

    /**
     * 判断队列是否为空
     * @return true 为空
     */
    @Override
    public boolean isEmpty() {
        return linkListDummyHead.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkListQueue{" +
                "linkListDummyHead=" + linkListDummyHead +
                '}';
    }
}
