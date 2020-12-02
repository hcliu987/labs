package com.hc.springboot.lab16.springdatamongodb.repository;

import com.hc.springboot.lab16.springdatamongodb.Application;
import com.hc.springboot.lab16.springdatamongodb.dataobject.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void testInsert() {
    //创建userDO对象
    UserDO user = new UserDO();
    user.setId(1); // 这里先临时写死一个 ID 编号，后面演示自增 ID 的时候，在修改这块
    user.setUsername("yudaoyuanma");
    user.setPassword("buzhidao");
    user.setCreateTime(new Date());
    // 创建 Profile 对象
    UserDO.Profile profile = new UserDO.Profile();
    profile.setNickname("芋道源码");
    profile.setGender(1);
    user.setProfile(profile);
    // 存储到 DB
    userRepository.insert(user);
  }


  @Test // 更新一条记录
  public void testUpdate() {
    Optional<UserDO> userResult = userRepository.findById(1);
    Assert.isTrue(userResult.isPresent(), "用户一定要存在");
    //更修呢
    UserDO updateUser = userResult.get();
    updateUser.setUsername("yutou");
    userRepository.save(updateUser);

  }

  @Test // 根据 ID 编号，查询一条记录
  public void testSelectById() {
    Optional<UserDO> userDO = userRepository.findById(1);
    System.out.println(userDO.isPresent());
  }

  @Test // 根据 ID 编号数组，查询多条记录
  public void testSelectByIds() {
    Iterable<UserDO> users = userRepository.findAllById(Arrays.asList(1, 4));
    users.forEach(System.out::println);
  }
}
