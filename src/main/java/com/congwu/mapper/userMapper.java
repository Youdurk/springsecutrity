package com.congwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.congwu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper extends BaseMapper<User> {
    @Select("select * from stu where username=#{name}")
    User byname(String name);
}
