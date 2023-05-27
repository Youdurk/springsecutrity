package com.congwu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("stu")
public class User {
    private int id;
    private  String username;
    private String password;
    private String role;
    private String eamil;
}
