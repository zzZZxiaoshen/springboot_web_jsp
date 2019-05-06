package cn.pinghu.springboot_web_jsp.utils.Data;

public interface Stack<T> {

    void push(T element);

    T pop();

    T peek();

    int getSize();

    boolean isEmpty();

}
