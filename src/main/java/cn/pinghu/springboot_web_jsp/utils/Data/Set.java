package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 定义数据类型抽象概念接口
 * @author shenkai
 * @date 2019/5/14
 */
public interface Set<T extends Comparable> {

    void add(T element);

    boolean contain(T element);

    int getSize();

    Boolean isEmpty();

    void remove(T element);


}
