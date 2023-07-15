package com.congwu.config;


import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.congwu.entity.Users;
import com.congwu.exception.ServiceException;
import com.congwu.mapper.userMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor  implements HandlerInterceptor {
    @Resource
    userMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        System.out.printf(""+authentication.getPrincipal());
        User user=(User) authentication.getPrincipal();
        String username = user.getUsername();
        if (username.equals(null)){
            throw new  ServiceException("400","系统错误");
        }
        System.out.printf(""+username);
        Users account = userMapper.selectOne(new QueryWrapper<Users>().eq("username",username));
        if (ObjUtil.equal(account,null)){
            throw new  ServiceException("400","请重新登录");
        }
        request.getSession().setAttribute("account", account);
        return true;
    }
}
