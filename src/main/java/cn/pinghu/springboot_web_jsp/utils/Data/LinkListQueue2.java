package cn.pinghu.springboot_web_jsp.utils.Data;


import org.apache.commons.lang3.StringUtils;

/**
 * 链表队列
 * @author shenkai
 * @date 2019/5/10
 */
public class LinkListQueue2<T>  implements Queue<T>{

    private class Node {
        private T element;
        private Node next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node head, tail;
    private int size;

    public LinkListQueue2(){
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * 入队 时间复杂度 o1
     * @param element
     */
    @Override
    public void enQueue(T element) {
        if (tail == null) {
            head = new Node(element);
            tail = head;
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队 时间复杂度 o1
     * @return 出队元素
     */
    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue erro");
        }
        Node res = head;
        head = res.next;
        res.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return res.element;
    }

    @Override
    public T getFront() {
        if (head != null) {
            return head.element;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "LinkListQueue2{" +
                "head=" + head.element +
                ", tail=" + tail.element+
                ", size=" + size +
                '}';
    }


}
