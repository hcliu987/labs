package com.hc.lab12.mybatis.controller;

import com.hc.lab12.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/selectid/{id}")
  public String selectUserById(Integer id) throws Exception {
    return userService.selectUserById(id);
  }

  @GetMapping("/user1/{userid}")
  public String selectUserById2(@PathVariable("userid") Integer userid) throws Exception {
    return userService.selectByid(userid);
  }

  @GetMapping("/user/{id}")
  public String select(@PathVariable("id") Integer id) {
    return userService.synchronizedSelectUserById(id);
  }
}