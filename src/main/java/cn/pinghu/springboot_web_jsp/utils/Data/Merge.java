package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 自定义结构融合器
 * @author shenkai
 * @date 2019/5/17
 */
public interface Merge<T> {

    T merge(T a, T b);

}
