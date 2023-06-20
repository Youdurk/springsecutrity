package com.congwu.service.servicelmpl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.congwu.entity.Users;
import com.congwu.entity.dto.UserDto;
import com.congwu.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username ==null){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Users::getUsername,username);
        Users u=userMapper.selectOne(queryWrapper);
        if (u==null){
            throw  new UsernameNotFoundException("无用户");
        }
        return User.withUsername(u.getUsername())
                .password(u.getPassword())
                .roles("ADMIN").build();
    }

    @Override
    public boolean emailsend(String email) {
        if (email !=null){
            String key="yanzhen"+email;
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mail);
            message.setTo(email);
            message.setSubject("测试");
            int code= RandomUtil.randomInt(50,100);
            stringRedisTemplate.opsForValue().set(key, String.valueOf(code),3, TimeUnit.MINUTES);
            message.setText("你的验证码为："+code);
            mailSender.send(message);
            return true;
        }
        return false;
    }

    @Override
    public boolean regint(UserDto user) {
        String key="yanzhen"+user.getEamil();
       if (user !=null){
           String code=stringRedisTemplate.opsForValue().get(key);
           if (code.equals(null) && code.equals("")){
               return false;
           }
           if (code.equals(user.getCode())){
               LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
               wrapper.eq(Users::getUsername,user.getUsername());
               Users usr=  userMapper.selectOne(wrapper);
               if (usr==null){
                   Users us = new Users();
                   us.setUsername(user.getUsername());
                   us.setPassword(encoder.encode(user.getPassword()));
                   us.setEmali(user.getEamil());
                   stringRedisTemplate.delete(key);
                   userMapper.insert(us);
                   return true;
               }else
               {
                   return false;
               }

           }else {
               return false;
           }
       }
        return false;
    }

//    public  String ss(){
//        String key="yanzhen";
//        int code= RandomUtil.randomInt(50,100);
//        System.out.printf(""+code);
//        stringRedisTemplate.opsForValue().set(key, String.valueOf(code));
//        return  stringRedisTemplate.opsForValue().get(key);
//    }

}
