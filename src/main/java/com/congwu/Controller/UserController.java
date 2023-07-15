package com.congwu.Controller;


import cn.hutool.core.util.ObjUtil;
import com.congwu.common.Result;

import com.congwu.entity.Users;
import com.congwu.entity.dto.UserDto;
import com.congwu.mapper.userMapper;
import com.congwu.service.servicelmpl.UserServiceimpl;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
  private UserServiceimpl userServiceimpl;
    @PostMapping
    public Result re_email(@RequestParam("email") String email){
      boolean b=  userServiceimpl.emailsend(email);
      if (b){
          return Result.seccess(b);
      }
      return Result.error("400","验证失败");
    }

    @PostMapping("/regint")
    public Result regint01(@RequestBody UserDto user){

        return Result.seccess( userServiceimpl.regint(user));
    }
    @PostMapping("/res")
    public void  ce(@RequestParam Map<String,String> ma){

        System.out.printf("测试："+ma.get("email"));
    }

}
