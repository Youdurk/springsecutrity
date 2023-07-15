package com.congwu.demo;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.congwu.service.servicelmpl.UserServiceimpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;


@SpringBootTest

class ApplicationTests {

//    @Value("${spring.mail.username}")
//    String mail;
//    @Resource
//    MailSender mailSender;
    @Resource
    UserServiceimpl userServiceimpl;
    @Test
    void contextLoads() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        System.out.print("" + authentication.getPrincipal());
//        QueryWrapper<user> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(user::getUsername,"admin");
//        user u= userMapper.selectOne(queryWrapper);
//        System.out.printf(""+u);
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(mail);
//        message.setTo(mail);
//        message.setSubject("测试");
//        int code= RandomUtil.randomInt(50,100);
//        System.out.printf(""+code);
//        message.setText("你的验证码为："+code);
//        mailSender.send(message);
//        String key="yanzhen";
//    String code=userServiceimpl.ss();
//        System.out.printf(""+code);

    }



}
