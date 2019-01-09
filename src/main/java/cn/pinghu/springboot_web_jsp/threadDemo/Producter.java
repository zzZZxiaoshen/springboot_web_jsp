package cn.pinghu.springboot_web_jsp.threadDemo;

/**
 * 线程的生产者
 * @author shenkai
 * @date 2019/1/3
 */
public class Producter implements Runnable{
    private Clerk clerk;

    public Producter(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.producter();
        }
    }
}
