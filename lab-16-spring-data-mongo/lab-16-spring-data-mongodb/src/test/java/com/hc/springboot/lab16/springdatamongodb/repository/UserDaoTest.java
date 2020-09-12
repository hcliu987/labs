package com.hc.springboot.lab16.springdatamongodb.repository;

import com.hc.springboot.lab16.springdatamongodb.Application;
import com.hc.springboot.lab16.springdatamongodb.dao.UserDao;
import com.hc.springboot.lab16.springdatamongodb.dataobject.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public  void testInsert(){
        // 创建 UserDO 对象
        UserDO user = new UserDO();
        user.setId(2); // 这里先临时写死一个 ID 编号，后面演示自增 ID 的时候，在修改这块
        user.setUsername("yudaoyuanma");
        user.setPassword("buzhidao");
        user.setCreateTime(new Date());
        // 创建 Profile 对象
        UserDO.Profile profile = new UserDO.Profile();
        profile.setNickname("芋道源码");
        profile.setGender(1);
        user.setProfile(profile);
        // 存储到 DB
        userDao.insert(user);
    }

    @Test
    public  void testUpdate(){
        UserDO updateUser =new UserDO();
        updateUser.setId(2);
        updateUser.setUsername("nicai");
        userDao.updateById(updateUser);
    }
    @Test
    public void testDelete(){
        userDao.deleteById(1);
    }
    @Test
    public  void testSelectById(){
        UserDO user = userDao.findById(2);
        System.out.println(user);
    }

    @Test
    public  void testSelectByIds(){
        List<UserDO> users = userDao.findAllById(Arrays.asList(2, 4));
        users.forEach(System.out::println);
    }
}
