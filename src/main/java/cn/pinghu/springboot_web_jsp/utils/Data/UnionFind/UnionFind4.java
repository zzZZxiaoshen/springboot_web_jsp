package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

/**
 * 并查集实现方式四
 * @author shenkai
 * @date 2019/5/28
 */
public class UnionFind4 implements UF {

    /**
    *   rank[i]表示以i为根的集合所表示的树的层数
     *  用于参考树的高度，并不实际反应树的高度。在路径压缩的时候不用维护这个变量，用于提高性能。
    */
    private int[] rank;
    /**
    *  parent[i]表示第i个元素所指向的父节点
    */
    private int[] parent;

    public UnionFind4(int num) {
        this.parent = new int[num];
        this.rank = new int[num];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
            rank[i] = 1;
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

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }


    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] =qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
