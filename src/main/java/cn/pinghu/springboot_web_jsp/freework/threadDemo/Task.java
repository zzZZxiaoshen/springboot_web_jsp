package cn.pinghu.springboot_web_jsp.freework.threadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 卖票
 *
 * @author shenka i
 * @date 2019/1/3
 */
public class Task implements Runnable {

    private int tikct = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (tikct>0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName()+tikct--);
            }
            lock.unlock();
        }
    }


}
