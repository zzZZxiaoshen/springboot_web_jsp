package cn.pinghu.springboot_web_jsp.utils.Data;


/**
 * 链表 加头设计
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkListDummyHead<T> {

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

    private Node dummyHead;
    private int size;

    public LinkListDummyHead() {
        this.dummyHead = new Node();
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
        add(element, 0);
    }

    /**
     * 向链表中间插入  在对应索引位置上插入元素
     * @param element 元素
     * @param index 索引
     * 插入元素的位置 与索引的关系 如何去记住 认识 （具体看设计）
     *  1. 索引与实际业务需求没有关系 ，此时业务与索引就是两个概念需要分开
     *  2. 索引与实际业务需求有直接关系，代表业务含义，比如这里的索引代表节点的位置。
     *
     * 注意我们的目的是获得插入位置前一个节点（核心关键） 更新元素内容的时候获取的就是对应位置的信息不是前一个节点的信息
     *
     * 在链表中真实的头结点情况 如果我要向元素的对应位置插入元素的话 那么我需要遍历得到这个位置的前一个元素 然后通过前一个元素的node应用获取对应位置的信息 并插入
     * 在这里我们的处理是将索引减一获得对应位置的前一个元素
     *
     * 在链表中我们自定义一个空节点加头 ， 如果我们要向元素对应位置插入元素的话。 那么我需要遍历得到这个位置的前一个元素，但是与真头 所区别的是加头的第一个元素是空的
     * 在这里我们的处理是遍历索引获得对应位置的前一个元素
     */
    public void  add(T element,int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("add linkList index lt size");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.node;
        }
         preNode.node= new Node(element,preNode.node);
        size++;
    }

    /**
     * 向尾部加入元素
     */
    public void addLast(T element) {
        add(element,size);
    }

    /**
     * 获取索引位置处的元素内容
     * @param index 索引位置
     * @return 索引位置的数据
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("add linkList index lt size");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.node;
        }
        // 获取索引位置处的数据
        return preNode.node.element;
    }

    /**
     * 修改链表中的元素 修改对应索引位置上的元素内容
     * @param element 元素
     * @param index 索引位置
     */
    public void set(T element, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("add linkList index lt size");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.node;
        }
        // 修改元素
        preNode.node.element = element;
    }


    /**
    * 查找链表中是否包含该元素
    */

    public Boolean contain(T element){
        Node preNode = dummyHead;
        for (int i = 0; i < size; i++) {
            preNode = preNode.node;
            if (preNode.element == element) {
                return true;
            }
        }
        return Boolean.FALSE;
    }



    @Override
    public String toString() {
        return "LinkListDummyHead{" +
                "dummyHead=" + dummyHead +
                ", size=" + size +
                '}';
    }
}
