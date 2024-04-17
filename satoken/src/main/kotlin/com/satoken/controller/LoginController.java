package com.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.satoken.model.Account;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录测试
 */
@RestController
@RequestMapping("/acc/")
@Tag(name = "登录测试")
public class LoginController {

    // 测试登录  ---- http://localhost:8080/acc/doLogin?name=zhang&pwd=123456
    @GetMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
//            return null;
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    // 查询登录状态  ---- http://localhost:8080/acc/isLogin
    @GetMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8080/acc/tokenInfo
    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8080/acc/logout
    @GetMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

}
