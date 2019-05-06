package cn.pinghu.springboot_web_jsp.utils.Data;

/**
 * 栈结构自定义实现
 * @author shenkai
 * @date 2019/5/6
 */
public class ArrayStack<T> implements Stack<T> {

    private Array<T> array = new Array<>();

    /**
     * 压栈
     * @param element
     */
    @Override
    public void push(T element) {
        array.addLast(element);
    }

    /**
     * 弹栈
     * @return 弹出栈顶得元素
     */
    @Override
    public T pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶得元素
     * @return 栈顶得元素 信息
     */
    @Override
    public T peek() {
        return array.get(array.getSize()-1);
    }

    /**
     * 得到栈中得元素大小
     * @return 栈中得元素大小
     */
    @Override
    public int getSize() {
        return array.getSize();
    }


    /**
     *  总结：本质 判断的返回结果 根据具体的业务 或者 判断的设计 来返回
     *        比如在这里将数组当第三人称与 当成第一人称返回接判断结果是不同的
     *        但是经验来看在程序设计中 总是将事物当做第三人称去判断而不是第一人称
     *  逻辑误区  数组是否为空案例
     * 因为我们这里处理的逻辑就是判断 数组是否为空 数组是第三方法 我们去判断处理数组
     *          此时我们认为是空 就是符合条件为true 不符合条件 为flase
     *
     * 误区 ：而不是 数组不是空 直接拿来使用判断 此时数组是第一方 数组本身是不为空的，
     *          此时数组不为空符合条件 为true ，为空的时候不符合条件 为false。
     */
    /**
     * 判断栈 是否为空
     * @return true 为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
