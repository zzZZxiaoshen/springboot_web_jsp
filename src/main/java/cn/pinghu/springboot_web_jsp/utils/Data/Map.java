package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 定义map映射数据结构抽象概念接口
 * @author shenkai
 * @date 2019/5/14
 */
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();

}