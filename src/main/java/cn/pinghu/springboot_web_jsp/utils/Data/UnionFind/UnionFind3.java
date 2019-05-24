package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

/**
 * 并查集实现方式三
 * @author shenkai
 * @date 2019/5/24
 */
public class UnionFind3 implements UF {

    /**
    * 此时数组的索引表示内容，存储的内容代表指向父亲节点，指向同一个节点的表示同一个集合
    */
    private int[] parent ;
    private int[] sz;// sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    public int find(int element) {
        if(element < 0 || element >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (element != parent[element])
            element = parent[element];
        return element;
    }

    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return  find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (sz[p] < sz[q]) {
            parent[p] = qRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            parent[p] = qRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
