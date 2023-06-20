package com.congwu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.congwu.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper extends BaseMapper<Users> {
    @Select("select * from stu where username=#{name}")
    Users byname(String name);
}
