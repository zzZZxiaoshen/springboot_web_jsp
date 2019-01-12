package cn.pinghu.springboot_web_jsp.freework.threadDemo;

/**
 * 死锁任务
 * @author shenkai
 * @date 2019/1/3
 */
public class DieLock implements Runnable {
    private final Object objA = new Object();
    private final Object objB= new Object();

    private boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (objA) {
                System.out.println("obja");
                synchronized (objB) {
                    System.out.println("objb");
                }
            }
        } else {
            synchronized (objB) {
                System.out.println("objb");
                synchronized (objA) {
                    System.out.println("obja");
                }
            }
        }

    }
}
