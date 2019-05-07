package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 *  队列接口
 * @author shenkai
 * @date 2019/5/7
 */
public interface Queue<T> {

    void  enQueue(T element);

    T deQueue();

    T getFront();

    int getSize();

    boolean isEmpty();

}
