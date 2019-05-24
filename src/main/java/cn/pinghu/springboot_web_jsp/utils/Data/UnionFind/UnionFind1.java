package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

/**
 * 并查集实现方式一
 * @author shenkai
 * @date 2019/5/24
 */
public class UnionFind1 implements UF {

    /**
    * 此时数组对应的索引表示元素 ，存储的内容表示集合的id，相同的id表示相同的集合
    */
    private int[] ids ;

    public UnionFind1(int size) {
        this.ids = new int[size];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }


    @Override
    public int getSize() {
        return ids.length;
    }

    // 查找元素p所对应的集合编号
    public int find(int element) {
        return ids[element];
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 合并元素p和元素q所属的集合
    // O(n) 复杂度
    @Override
    public void unionElements(int p, int q) {
        int pUnion = find(p);
        int qUnion = find(q);
        if (pUnion !=qUnion) {
            ids[p] = qUnion;
        }
    }

}
