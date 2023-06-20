package com.congwu.service;

import com.congwu.entity.dto.UserDto;

public interface UserService{

    boolean emailsend(String email);

    boolean regint(UserDto user);
}
