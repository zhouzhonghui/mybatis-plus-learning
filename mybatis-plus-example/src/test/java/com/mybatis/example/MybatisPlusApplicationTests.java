package com.mybatis.example;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.example.entity.UserDailyStatEntity;
import com.mybatis.example.mapper.UserDailyStatMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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


    @Test
    public void testMapperInsert(){
        UserDailyStatEntity userDailyStatEntity =new UserDailyStatEntity();
        userDailyStatEntity.setActiveUsers("1");
        userDailyStatEntity.setChnl("11");
        userDailyStatEntity.setRegisterUsers("122");
        userDailyStatEntity.setStatTime("2019-09-19");
        int insert = userDailyStatMapper.insert(userDailyStatEntity);
        Assert.assertEquals(1,insert);
    }

    @Test
    public void testMapperDeletById(){
        int i = userDailyStatMapper.deleteById(24);
        Assert.assertEquals(1,i);
    }

    /**
     * 根据数据库中的字段进行删除
     */
    @Test
    public void testMapperDeleteByMap(){
        Map<String,Object> delMap=new HashMap<>();
        delMap.put("register_users","122");
        delMap.put("active_users","1");
        int i = userDailyStatMapper.deleteByMap(delMap);
        Assert.assertEquals(1,i);
    }

    @Test
    public void testDelete(){
        QueryWrapper<UserDailyStatEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("register_users","1").eq("active_users","3");
        int delete = userDailyStatMapper.delete(wrapper);
        Assert.assertEquals(1,delete);
    }

    @Test
    public void testDeleteBatchIds(){
        Collection<String> collection=new ArrayList<>();
        collection.add("22");
        collection.add("21");
        int i = userDailyStatMapper.deleteBatchIds(collection);
        Assert.assertEquals(2,i);
    }


    @Test
    public void testSelectById(){
        UserDailyStatEntity userDailyStatEntity = userDailyStatMapper.selectById(5);
        System.out.println(userDailyStatEntity);
    }

    @Test
    public void testSelectBatchIds(){
        Collection<String> collection=new ArrayList<>();
        collection.add("5");
        collection.add("6");
        collection.add("7");
        List<UserDailyStatEntity> userDailyStatEntities = userDailyStatMapper.selectBatchIds(collection);
        userDailyStatEntities.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("register_users","11");
        List<UserDailyStatEntity> userDailyStatEntities = userDailyStatMapper.selectByMap(map);
        userDailyStatEntities.forEach(System.out::println);
    }


    @Test
    public void testSelectOne(){
        QueryWrapper<UserDailyStatEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id","11");
        UserDailyStatEntity userDailyStatEntity = userDailyStatMapper.selectOne(queryWrapper);
        System.out.println(userDailyStatEntity);
    }

    @Test
    public void testSelectCount(){
        QueryWrapper<UserDailyStatEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("register_users","11");
        Integer integer = userDailyStatMapper.selectCount(queryWrapper);
        System.out.println(integer);
    }


    @Test
    public void testSelectList(){
        List<UserDailyStatEntity> userDailyStatEntities = userDailyStatMapper.selectList(null);
        userDailyStatEntities.forEach(System.out::println);
    }


    @Test
    public void testSelectMaps(){
        Map<String,Object> map=new HashMap<>();
        map.put("register_users","11");
        List<UserDailyStatEntity> userDailyStatEntities = userDailyStatMapper.selectByMap(map);
        userDailyStatEntities.forEach(userDailyStatEntity -> System.out.println(userDailyStatEntity.toString()));
    }

    @Test
    public void testSelectObj(){
        List<Object> objects = userDailyStatMapper.selectObjs(null);
        objects.forEach(System.out::println);
    }

    /**
     * @TODO 这块目前的分页有问题
     */
    @Test
    public void testSelectPage(){
        IPage<UserDailyStatEntity> iPage= new Page(1, 10, (long) 15);
        QueryWrapper<UserDailyStatEntity> wrapper=new QueryWrapper<>();
        IPage<UserDailyStatEntity> iPage1 = userDailyStatMapper.selectPage(iPage, wrapper);
        System.out.println(iPage1.getRecords().size()+"----------------");
        System.out.println(iPage1.getPages()+"------------");
    }



}
