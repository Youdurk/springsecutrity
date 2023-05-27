package com.congwu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.congwu.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService{

    boolean emailsend(String email);
}
