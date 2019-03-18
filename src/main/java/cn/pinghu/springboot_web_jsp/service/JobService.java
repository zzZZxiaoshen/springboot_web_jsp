package cn.pinghu.springboot_web_jsp.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时任务调度器
 * @author shenkai
 * @date 2019/1/2
 */
@Service
public class JobService {

    //@Scheduled(cron= "0 * * * * ?")
//    @Scheduled(cron = "0,1,2,3,4 * * * * ?")
    @Scheduled(cron = "0 0 1 15 * ?")
    public void testSchedules(){
        System.out.println("test");
    }
}
