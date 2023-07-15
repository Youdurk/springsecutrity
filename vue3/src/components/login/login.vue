
<template>
    <div style="text-align: center;margin: 0 20px">
        <div style="margin-top: 150px">
            <div style="font-size: 25px;font-weight: bold">登录</div>
            <div style="font-size: 14px;color: grey">在进入系统之前请先输入用户名和密码进行登录</div>
        </div>
        <div style="margin-top: 50px">
            <el-input v-model="form.username" type="text" placeholder="用户名/邮箱">
             
            </el-input>
            <el-input v-model="form.password" type="password" style="margin-top: 10px" placeholder="密码">
                
            </el-input>
        </div>
        <el-row style="margin-top: 5px">
            <el-col :span="12" style="text-align: left">
                <el-checkbox v-model="form.remember" label="记住我"/>
            </el-col>
            <el-col :span="12" style="text-align: right">
                <el-link >忘记密码？</el-link>
            </el-col>
        </el-row>
        <div style="margin-top: 40px">
            <el-button style="width: 270px" type="success" plain @click="login()">立即登录</el-button>
        </div>
        <el-divider>
            <span style="color: grey;font-size: 13px">没有账号</span>
        </el-divider>
        <div>
            <el-button style="width: 270px"  type="warning" @click="router.push('/register')" plain>注册账号</el-button>
        </div>
        <el-button style="width: 270px"  type="warning" @click="cs" plain>测试</el-button>
    </div>
</template>

<script setup>
import {reactive} from "vue"
import request from "@/net/request";
import {ElMessage} from "element-plus";
import router from "@/router";
const form=reactive({
    username:'',
    password:'',
    remember:false
})
const cs=()=>{

    request.post("/api/user/res",null,{params: {email:"25555",e:6}}).then(res=>{
    })
}
const login = ()=>{
    if(!form.username || !form.password) {
        ElMessage.warning('请填写用户名和密码！')
    } else {
        if(form !=null){
            request.post('/api/user/login',null,{params:{
          username: form.username,
              password:form.password,
              remember:form.remember
          }},).then(res=>{
        if(res.code=='200'){
            console.log(res)
            ElMessage.success(res.data)
            request.get("/api/user/me").then(re=>{
                if (re.code=='200'){
                    router.push("/index")
                }else if(re.code=="400"){
                    router.push("/")
                    ElMessage.success(re.msg)
                }

            })
        }
      })
        }
    
}
}
</script>

<style scoped>
</style>
