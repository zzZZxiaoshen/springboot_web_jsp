package cn.pinghu.springboot_web_jsp.threadDemo;

/**
 * 死锁测试类
 * @author shenkai
 * @date 2019/1/3
 */
public class MyThread3 {
    public static void main(String[] args) {

        DieLock dieLock1 = new DieLock(true);
        DieLock dieLock2 = new DieLock(false);
        new Thread(dieLock2).start();
        new Thread(dieLock1).start();


    }
}
