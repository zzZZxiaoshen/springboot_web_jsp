package cn.pinghu.springboot_web_jsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程测试类
 *
 * @author shenkai
 * @date 2019/1/3
 */
public class ExcutorTestDemo {

    @Test
    public void test01() {
        long start = System.currentTimeMillis();
        Callable<Object> callable = Executors.callable(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                int sum = 0;
                for (int i = 0; i < 1000; i++) {
                    sum += i;
                }
                long end = System.currentTimeMillis();
                System.out.println("task1= " + (end - start));
            }
        });
        try {
            Object call = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("main= " + (end - start));
    }


    @Test
    public void test02() {
        long start = System.currentTimeMillis();
        ExecutorService pool = (ExecutorService) Executors.newFixedThreadPool(5);
        List<Future<?>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> future = pool.submit(new Runnable() {
                @Override
                public void run() {
                    int sum = 0;
                    for (int j = 0; j < 100; j++) {
                        sum += j;
                    }
                    System.out.println(Thread.currentThread().getName()+sum);
                }
            });
            list.add(future);
        }
        pool.shutdown();

    }

    @Test
    public void test03() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService pool = (ExecutorService) Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int j = 0; j < 100; j++) {
                        sum += j;
                    }
                    return sum;
                }
            });
            list.add(future);
        }

        pool.shutdown();

        for (Future<Integer> integerFuture : list) {
            System.out.println(integerFuture.get());
        }
    }
}
