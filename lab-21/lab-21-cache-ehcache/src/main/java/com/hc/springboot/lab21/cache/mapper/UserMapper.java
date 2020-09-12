package com.hc.springboot.lab21.cache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hc.springboot.lab21.cache.dataobject.UserDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserMapper extends BaseMapper<UserDO> {
    @Cacheable(key = "#id")
    UserDO selectById(Integer id);

    @CachePut(key = "#user.id")
    default UserDO inserto(UserDO user) {
        this.insert(user);
        return user;
    }

    @CacheEvict(key = "#id")
    int deleteById(Integer id);
}
