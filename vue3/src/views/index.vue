<template>
<div><el-button type="primary" @click="loginout">退出登录</el-button></div>    
</template>
<script setup>
import {reactive} from "vue"
import request from "@/net/request";
import {ElMessage} from "element-plus";
import router from "@/router";
const loginout= () =>{
    request.post("/api/user/logout").then(res=>{
        console.log(res)
        ElMessage.success(res.date)
        router.push("/")
    })
}
</script>