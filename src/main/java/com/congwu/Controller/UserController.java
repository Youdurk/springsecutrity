package com.congwu.Controller;

import com.congwu.common.Result;
import com.congwu.entity.User;
import com.congwu.service.servicelmpl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
  private UserServiceimpl userServiceimpl;
   @Resource
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping
    public Result re_email(@RequestParam String email){
      boolean b=  userServiceimpl.emailsend(email);
      if (b){
          return Result.seccess(b);
      }
      return Result.error("400","验证失败");
    }

    @PostMapping
    public Result regint(@RequestBody User user){
        if (user.getEamil().equals(null)){
            throw new RuntimeException("错误");
        }
        String key="yanzhen"+user.getEamil();
        if (true){}
        stringRedisTemplate.opsForValue().get(key);
        return Result.seccess();
    }
}
