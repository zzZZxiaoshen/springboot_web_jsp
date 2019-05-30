package cn.pinghu.springboot_web_jsp.utils.Data.avl;

import cn.pinghu.springboot_web_jsp.utils.Data.Map;

/**
 * 平衡二叉树实现映射数据结构
 * @author shenkai
 * @date 2019/5/30
 */
public class AVLMap<K extends Comparable,V> implements Map<K,V> {

    private AVLTree<K, V> avlTree;

    public AVLMap() {
        this.avlTree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contain(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V newValue) {
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.getSize() == 0;
    }

}
