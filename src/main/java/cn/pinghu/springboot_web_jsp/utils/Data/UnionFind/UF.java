package cn.pinghu.springboot_web_jsp.utils.Data.UnionFind;

public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
