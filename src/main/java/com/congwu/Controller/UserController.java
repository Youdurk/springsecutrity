package com.congwu.Controller;

import com.congwu.common.Result;
import com.congwu.service.servicelmpl.UserServiceimpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
  private UserServiceimpl userServiceimpl;
    @PostMapping()
    public Result re_email(@RequestParam String email){
        userServiceimpl.emailsend(email);
        return Result.seccess();
    }

}
