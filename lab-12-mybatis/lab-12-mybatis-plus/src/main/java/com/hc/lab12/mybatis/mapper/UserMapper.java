package com.hc.lab12.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hc.lab12.mybatis.dataobject.UserDO;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {

  default UserDO selectByUsername(@Param("username") String username) {
    return selectOne(new QueryWrapper<UserDO>().eq("username", username));
  }

  List<UserDO> selectByids(@Param("ids") Collection<Integer> ids);

  default IPage<UserDO> selectPageByCreateTime(IPage<UserDO> page,
      @Param("createTime") Date createTime) {
    return selectPage(page, new QueryWrapper<UserDO>().gt("create_time", createTime));
  }
}
