package com.example.mybatis;

import com.example.MybatisApplication;
import com.example.tasks.AsyncThreadPoolTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class AsyncThreadPoolTasksTests {

    @Autowired
    private AsyncThreadPoolTasks asyncThreadPoolTasks;

    @Test
    public void test() throws Exception {

        for (int i = 0; i < 20; i++) {
            asyncThreadPoolTasks.doTaskOne();
            asyncThreadPoolTasks.doTaskTwo();
            asyncThreadPoolTasks.doTaskThree();
            if (i == 19) {
                System.exit(0);
            }
        }

        //Thread.currentThread().join();
    }

}
