package cn.pinghu.springboot_web_jsp.freework.threadDemo;

/**
 * 资源的消费者
 * @author shenkai
 * @date 2019/1/3
 */
public class Comsumer  implements  Runnable{
    private Clerk clerk;

    public Comsumer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.sale();
        }
    }
}
