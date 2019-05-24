package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

/**
 * 并查集实现方式二
 * @author shenkai
 * @date 2019/5/24
 */
public class UnionFind2 implements UF {

    /**
    * 此时数组的索引表示内容，存储的内容代表指向父亲节点，指向同一个节点的表示同一个集合
    */
    private int[] parent ;

    public UnionFind2(int size) {
        this.parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    public int find(int element) {
        while (element != parent[element])
            element = parent[element];
        return element;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return  find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pUnion = find(p);
        int qUnion = find(q);
        if (pUnion == qUnion) {
            return;
        }
        parent[pUnion] = qUnion;
    }
}
