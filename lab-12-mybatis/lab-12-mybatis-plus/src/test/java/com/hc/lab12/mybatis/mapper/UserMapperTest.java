package com.hc.lab12.mybatis.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hc.lab12.mybatis.Application;
import com.hc.lab12.mybatis.dataobject.UserDO;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Test
  public void testInsert() {
    UserDO user =
        new UserDO()
            .setUsername(UUID.randomUUID().toString())
            .setPassword("nicai")
            .setCreateTime(new Date())
            .setDeleted(0);
    userMapper.insert(user);
  }

  @Test
  public void testUpdateById() {
    UserDO user = new UserDO().setId(1).setPassword("wobucai");
    userMapper.updateById(user);
  }

  @Test
  public void testSelectByUsername() {
    System.out.println(userMapper.selectByUsername("yunai"));
  }

  @Test
  public void testSelectByIds() {
    System.out.println(userMapper.selectByids(Arrays.asList(1, 7)));
  }

  @Test
  public void testSelectPageByCreateTime() {
    IPage<UserDO> page = new Page<>(1, 10);
    Date createTime = new Date(2020 - 1990, Calendar.FEBRUARY, 24);
    System.out.println(userMapper.selectPageByCreateTime(page, createTime));
  }
}
