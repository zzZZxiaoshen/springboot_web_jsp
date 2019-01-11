package cn.pinghu.springboot_web_jsp.freework.threadDemo;

/**
 * 测试线程之间的共享资源解决问题
 * @author shenkai
 * @date 2019/1/3
 */
public class MyThread1 {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task, "窗口二").start();
        new Thread(task, "窗口一").start();
        new Thread(task, "窗口三").start();
    }
}
