package cn.pinghu.springboot_web_jsp.utils.Data;


import lombok.val;

/**
 * 链表 真头设计
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkListRealHead<T> {

    private class Node{
        T element;
        Node node;

        public Node(T element, Node node) {
            this.element = element;
            this.node = node;
        }

        public Node(T element) {
            this(element, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", node=" + node +
                    '}';
        }
    }

    private Node head;
    private int size;

    public LinkListRealHead() {
        this.head = null;
        this.size = 0;
    }

    /**
     *  获取链表中元素的大小
     * @return 元素大小
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return true 为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表头加入数据
     * @param element 元素
     */
    public void addFirst(T element){
        Node node = new Node();
       /* node.element = element;
        node.node = head;
        head = node;*/
        head = new Node(element, head);
        size++;
    }

    /**
     * 向链表中间插入数据 在对应索引位置上插入元素
     * @param element 元素
     * @param index 索引
     * 插入元素的位置 与索引的关系 如何去记住 认识 （具体看设计）
     *  1. 索引与实际业务需求没有关系 ，此时业务与索引就是两个概念需要分开
     *  2. 索引与实际业务需求有直接关系，代表业务含义，比如这里的索引代表节点的位置。
     *
     * 注意 索引与实际位置业务需求的区别。这里的概念要区分开，存在概念误区。
     *
     * 注意我们的目的是获得插入位置前一个元素（核心关键）
     * 在链表中真实的头结点情况 如果我要向元素的对应位置插入元素的话 那么我需要遍历得到这个位置的前一个元素 然后通过前一个元素的node应用获取对应位置的信息 并插入
     * 在这里我们的处理是将索引减一获得对应位置的前一个元素
     *
     * 在链表中我们自定义一个空节点加头 ， 如果我们要向元素对应位置插入元素的话。 那么我需要遍历得到这个位置的前一个元素，但是与真头 所区别的是加头的第一个元素是空的
     * 在这里我们的处理是遍历索引获得对应位置的前一个元素
     */
    public void  add(T element,int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node preNode = head;
        // index 表示插入的为位置索引
        for (int i = 0; i < index-1; i++) {
            preNode = preNode.node;
        }
        if (index == 0) {
            addFirst(element);
        } else {
          /*  newNode.element = element;
            newNode.node = preNode.node;
            preNode.node = newNode;*/
            preNode.node = new Node(element, preNode.node);
            size++;
        }
    }

    /**
     * 向尾部加入元素
     */
    public void addLast(T element) {
     /*   Node lastNode = head;
        for (int i = 0; i < size; i++) {
            lastNode = head.node;
        }
        lastNode.node= new Node(element, null);*/
        add(element, size);
    }


    /**
     * 删除链表中所有相同的元素(循环方法)
     * @param val 需要被删除的元素
     */
    public Node  removeEelement1(T val) {
        // 处理链表头
        if (head != null && head.element.equals(val)) {
            Node delNode = head;
            head = delNode.node;
            delNode.node = null;
        }
        if (head == null) {
            return null;
        }
        // 处理链表中部以及尾部
        Node preNode = head.node;
        while (preNode.node != null) {
            if (head.element.equals(val)) {
                Node delNode = head.node;
                preNode.node = delNode.node;
                delNode.node = null;
                size--;
            } else {
                preNode = preNode.node;
            }
        }
        return head;
    }

    /**
     * 删除链表中所有相同的元素（递归算法）
     * @param val 需要被删除的元素
     */
    public Node  removeEelement2(Node node ,T val) {

        if (head == null) {
            return null;
        }
        Node res = removeEelement2(node.node, val);
        if (node.element.equals(val)) {
            return res;
        } else {
            node.node = res;
            return node;
        }

    }

    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

}
