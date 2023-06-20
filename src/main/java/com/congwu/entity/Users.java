package com.congwu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("stu")
public class Users {
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private int id;
    private  String username;
    private String password;
    private String role;
    private String emali;
}
