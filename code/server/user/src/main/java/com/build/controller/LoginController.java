package com.build.controller;

import com.build.common.Result;
import com.build.common.VerifyToken;
import com.build.entity.Navigation;
import com.build.entity.Right;
import com.build.service.AccountService;
import com.build.service.NavigationService;
import com.build.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 登录注册接口
 */
@Api("登录注册接口")
@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NavigationService navigationService;

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "登录", notes = "登录系统")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "账号", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(String userName, String password) {
        return this.userService.checkUser(userName, password);
    }


    @VerifyToken
    @RequestMapping(value = "/checkPermission", method = RequestMethod.GET)
    public Result checkPermission(String token, String navigationRoute) {
        return this.userService.checkPermission(token, navigationRoute);
    }

    @VerifyToken
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Result updatePassword(String token, String oldPassword, String newPassword) {
        return this.userService.updatePassword(token, oldPassword, newPassword);
    }
}
