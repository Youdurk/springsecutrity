package com.congwu.exception;

import com.congwu.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GbloException {
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handler(ServiceException se){
        return Result.error(se.getCode(),se.getMessage());
    }
}
