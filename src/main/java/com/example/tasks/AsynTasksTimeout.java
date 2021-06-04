package com.example.tasks;

//import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 异步任务
 *
 * Spring Boot中使用@Async实现异步调用
 */
//@Slf4j
@Component
public class AsynTasksTimeout {

    public static Random random = new Random();

    @Async("taskExecutor")
    public Future<String> run() throws Exception {
//        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
//        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }



}
