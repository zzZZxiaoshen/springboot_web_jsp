package cn.pinghu.springboot_web_jsp.utils.Data;

import java.util.LinkedList;

/**
 * 数据结构抽象概念接口set 实现(链表数据结构实现set集合数据结构抽象概念)
 * @author shenkai
 * @date 2019/5/14
 */
public class LinkListSet<T extends Comparable> implements Set<T> {

    private LinkedList linkedList;

    public LinkListSet() {
        this.linkedList = new LinkedList();
    }

    @Override
    public void add(T element) {
        if (!contain(element)) {
            linkedList.add(element);
        }
    }

    @Override
    public boolean contain(T element) {
        return linkedList.contains(element);
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }

    @Override
    public Boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void remove(T element) {
        linkedList.remove(element);
    }




}
