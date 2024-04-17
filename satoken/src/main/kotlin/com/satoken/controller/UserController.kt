package com.satoken.controller

import cn.dev33.satoken.stp.StpUtil
import com.satoken.model.Account
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController {

    @GetMapping("login")
    fun login(name: String, password: String) =
        if ("zhang" == name && "123456" == password) {
            StpUtil.login(name)
            "登录成功"
        } else "登录失败"
}


