package com.example.mybatis;

import com.example.MybatisApplication;
import com.example.tasks.AsynchronizationTasks;
import com.example.tasks.SynchronizationTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
@ComponentScan(basePackages = "com.example.tasks")
public class SynchronizationTasksTests {

    @Autowired
    private SynchronizationTasks synchronizationTasks;

    @Autowired
    private AsynchronizationTasks asynchronizationTasks;

    /**
     * 测试同步任务调用
     * @throws Exception
     */
/*    @Test
    public void test() throws Exception {
        synchronizationTasks.doTaskOne();
        synchronizationTasks.doTaskTwo();
        synchronizationTasks.doTaskThree();
    }*/

    /**
     * 测试异步任务调用
     * @throws Exception
     */
    @Test
    public void AsynchronizationTasksTest() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = asynchronizationTasks.doTaskOne();
        Future<String> task2 = asynchronizationTasks.doTaskTwo();
        Future<String> task3 = asynchronizationTasks.doTaskThree();

        while (true){
            if( task1.isDone() && task2.isDone() && task3.isDone() ){
                //三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }


}
