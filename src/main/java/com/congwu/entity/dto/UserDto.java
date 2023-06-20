package com.congwu.entity.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private  String username;
    private String password;
    private String password_repeat;
    private String role;
    private String eamil;
    private String code;
}
