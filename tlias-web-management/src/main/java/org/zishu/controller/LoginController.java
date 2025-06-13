package org.zishu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zishu.pojo.Emp;
import org.zishu.pojo.LoginInfo;
import org.zishu.pojo.Result;
import org.zishu.service.EmpService;

/**
 * 登录Controller
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){//json格式的参数想封装到实体类中，需要用@RequestBody
        log.info("登录：{}",emp);
        LoginInfo info = empService.login(emp);
        if(info != null) {
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }


}
