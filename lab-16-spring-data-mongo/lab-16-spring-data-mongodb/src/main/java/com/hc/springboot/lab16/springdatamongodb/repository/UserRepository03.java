package com.hc.springboot.lab16.springdatamongodb.repository;

import com.hc.springboot.lab16.springdatamongodb.dataobject.UserDO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository03 extends MongoRepository<UserDO, Integer> {

  //使用username 精准匹配
  default UserDO fingByUsername01(String username) {
    //创建 Example对象,使用username查询
    UserDO probe = new UserDO();
    probe.setUsername(username);
    Example<UserDO> example = Example.of(probe);
    //执行查询
    return findOne(example).orElse(null);
  }


  default UserDO findByUsernameLike01(String username) {
    UserDO probe = new UserDO();
    probe.setUsername(username);
    ExampleMatcher matcher = ExampleMatcher.matching()
        .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains());
    Example<UserDO> example = Example.of(probe, matcher);
    return findOne(example).orElse(null);
  }

}
