package com.hc.springboot.labs.lab10.springdatarediswithjedis.cacheobject;

import java.io.Serializable;

public class UserCacheObject  implements Serializable {
    private static final long serialVersionUID = -5656244102120496194L;
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public UserCacheObject setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserCacheObject setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserCacheObject setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "UserCacheObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
