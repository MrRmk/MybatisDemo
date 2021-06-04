package com.example.mybatis;

import com.example.MybatisApplication;
import com.example.tasks.AsynTasksTimeout;
import com.example.tasks.AsyncThreadPoolTasks;
//import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class AsyncTasksTimeoutTests {

    @Autowired
    private AsynTasksTimeout asynTasksTimeout;

    @Test
    public void test() throws Exception {

        Future<String> futureResult = asynTasksTimeout.run();
        String result = futureResult.get(5, TimeUnit.SECONDS);
//        log.info("result: " + result);
    }

}
