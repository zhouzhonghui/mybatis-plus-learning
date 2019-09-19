package com.mybatis.example;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.example.entity.UserDailyStatEntity;
import com.mybatis.example.mapper.UserDailyStatMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Autowired
    private UserDailyStatMapper userDailyStatMapper;
    @Test
    public void contextLoads() {

    }

    @Test
    public void testUserDailyStat(){
        Wrapper<UserDailyStatEntity> wrapper=new QueryWrapper<>();
        List<UserDailyStatEntity> userDailyStatEntities = userDailyStatMapper.selectList(wrapper);
        userDailyStatEntities.forEach(System.out::println);

    }

}
