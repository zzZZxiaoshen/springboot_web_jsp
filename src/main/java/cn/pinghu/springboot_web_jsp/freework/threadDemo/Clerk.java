package cn.pinghu.springboot_web_jsp.freework.threadDemo;

/**
 * 店员
 *
 * @author shenkai
 * @date 2019/1/3
 */
public class Clerk {

    /**
    *销售的产品恭喜资源类
    */
    private int ticket;

    /**
    * 卖产品方法功能
    */
    public synchronized void sale(){
        if (ticket <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("产品已经卖完了");
        } else {
            System.out.println(Thread.currentThread().getName()+":"+ --ticket);
            this.notifyAll();
        }

    }

    /**
     * 买产品方法功能
     */
    public synchronized void producter(){
        if (ticket >= 5) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("产品已经满了");
        } else {
            System.out.println(Thread.currentThread().getName() +":"+ ++ticket);
            this.notifyAll();
        }
    }
}
