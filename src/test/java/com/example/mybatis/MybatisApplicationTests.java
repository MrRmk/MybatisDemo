package com.example.mybatis;

import com.example.MybatisApplication;
import com.example.domain.User;
import com.example.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
@MapperScan("com.example.domain")
public class MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void contextLoads() {
        //添加
        int ins = userMapper.insert("AAAA", 20);
        //查询
        User u = userMapper.findByName("AAAA");
        Assert.assertEquals(20, u.getAge().intValue());
        if ( ins == 1 ) {
            System.out.println("添加数据成功，查询结果如下：");
            System.out.println(" id: " + u.getId() + ", name: " + u.getName() + ", age: " + u.getAge());
        }
        //更新
        u.setAge(30);
        int upd = userMapper.update(u);
        if( upd == 1 ){
            System.out.println("更新数据成功");
        }
        //查询
        u = userMapper.findByName("AAAA");
        Assert.assertEquals(30, u.getAge().intValue());

        //删除
        int del = userMapper.delete(u.getId());
        if( del == 1 ) {
            System.out.println("删除成功");
        }
//        Assert.assertEquals(null, u);

        //添加
        Map<String, Object> map = new HashMap<>();
        map.put("name", "CCC");
        map.put("age", 40);
        int insByMap = userMapper.insertByMap(map);
        if( insByMap == 1 ){
            System.out.println("添加数据成功---------CCC:40");
        }
        User u2 = userMapper.findByName("CCC");
        int del2 = userMapper.delete(u2.getId());
        if( del2 == 1 ){
            System.out.println("删除数据成功----------CCC:40");
        }

    }

}
