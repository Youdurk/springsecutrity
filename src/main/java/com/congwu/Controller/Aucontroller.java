package com.congwu.Controller;

import cn.hutool.core.util.ObjUtil;
import com.congwu.common.Result;
import com.congwu.entity.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/ss")
public class Aucontroller {
    @GetMapping("/me")
    public Result me(@SessionAttribute("account") Users user)  {
        if(ObjUtil.equal(user,null)){
            return Result.error("400","该用户未登录");
        }
        return Result.seccess(user);
    }
}
