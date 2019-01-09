package cn.pinghu.springboot_web_jsp.threadDemo;
/**
 * 测试线程之间的通信
 * @author shenkai
 * @date 2019/1/3
 */
public class MyThread2 {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producter producter = new Producter(clerk);
        Comsumer comsumer = new Comsumer(clerk);
        new Thread(producter,"生产者").start();
        new Thread(comsumer,"消费着").start();
    }

}
