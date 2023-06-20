package com.congwu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;


    public  static  Result seccess(){
        return new Result("200","",null);
    }
    public  static  Result seccess(Object data){
        return new Result("200","",data);
    }
    public  static  Result error(String code){
        return new Result(code,"",null);
    }
    public  static  Result error(String code,String msg){
        return new Result(code,msg,null);
    }
}
