package cn.pinghu.springboot_web_jsp.utils.Data.avl;

import cn.pinghu.springboot_web_jsp.utils.Data.Set;

/**
 * 平衡二叉树集合
 * @author shenkai
 * @date 2019/5/30
 */
public class AVLlSet<K extends Comparable,V> implements Set<K> {

    private AVLTree<K, V> avlTree;

    public AVLlSet() {
        this.avlTree = new AVLTree<>();
    }


    @Override
    public void add(K element) {
        avlTree.add(element,null);
    }

    @Override
    public boolean contain(K element) {
        return avlTree.contain(element);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return avlTree.getSize() == 0;
    }

    @Override
    public void remove(K element) {
        avlTree.remove(element);
    }
}
