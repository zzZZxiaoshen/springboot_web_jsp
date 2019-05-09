package cn.pinghu.springboot_web_jsp.utils.Data;


/**
 * 链表接口
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkList<T> {

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

    /**
     *  获取链表中元素的大小
     * @return 元素大小
     */
    public int getSize(){
        return size;
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
     * 向链表中间插入数据
     * @param element 元素
     * @param index 索引
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


}
