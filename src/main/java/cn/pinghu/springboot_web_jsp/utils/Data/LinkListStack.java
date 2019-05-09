package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 链表栈
 * @author shenkai
 * @date 2019/5/9
 */
public class LinkListStack<T> implements Stack<T> {


    private LinkListDummyHead<T> linkListDummyHead;

    public LinkListStack() {
        this.linkListDummyHead = new LinkListDummyHead<>() ;
    }

    /**
     * 压入栈
     * @param element 元素
     */
    @Override
    public void push(T element) {
        linkListDummyHead.addLast(element);
    }

    /**
     * 弹出栈
     * @return 栈顶元素
     */
    @Override
    public T pop() {
        return linkListDummyHead.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    @Override
    public T peek() {
        return linkListDummyHead.getLast();
    }

    /**
     * 获取栈中元素大小
     * @return 栈中元素大小
     */
    @Override
    public int getSize() {
        return linkListDummyHead.getSize();
    }


    /**
     * 判断栈中是否为空
     * @return true 为空
     */
    @Override
    public boolean isEmpty() {
        return linkListDummyHead.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkListStack{" +
                "linkListDummyHead=" + linkListDummyHead +
                '}';
    }

}
