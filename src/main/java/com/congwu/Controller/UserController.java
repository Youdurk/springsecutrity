package com.congwu.Controller;

import com.congwu.common.Result;
import com.congwu.service.servicelmpl.UserServiceimpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
  private UserServiceimpl userServiceimpl;
    @PostMapping
    public Result re_email(){
        userServiceimpl.emailsend();
        return Result.seccess();
    }

}
