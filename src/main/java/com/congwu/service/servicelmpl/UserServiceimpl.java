package com.congwu.service.servicelmpl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.congwu.entity.User;
import com.congwu.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimpl implements UserService, UserDetailsService {

    @Value("${spring.mail.username}")
    String mail;
    @Resource
    com.congwu.mapper.userMapper userMapper;
    @Resource
    MailSender mailSender;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username ==null)
            throw new UsernameNotFoundException("用户名不能为空");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        User u=userMapper.selectOne(queryWrapper);
        if (u==null){
            throw  new UsernameNotFoundException("无用户");
        }
        return org.springframework.security.core.userdetails.User.withUsername(u.getUsername())
                .password(u.getPassword())
                .roles("ADMIN").build();
    }

    @Override
    public boolean emailsend() {
        String key="yanzhen";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail);
        message.setTo(mail);
        message.setSubject("测试");
        int code= RandomUtil.randomInt(50,100);
        System.out.printf(""+code);
        stringRedisTemplate.opsForValue().set(key, String.valueOf(code));
        message.setText("你的验证码为："+code);
        mailSender.send(message);
        return false;
    }

    public  String ss(){
        String key="yanzhen";

        return  stringRedisTemplate.opsForValue().get(key);
    }

}
