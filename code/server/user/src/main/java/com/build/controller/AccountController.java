package com.build.controller;

import com.build.common.Result;
import com.build.common.VerifyToken;
import com.build.entity.Navigation;
import com.build.entity.Right;
import com.build.entity.User;
import com.build.service.AccountService;
import com.build.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账户相关接口
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private NavigationService navigationService;

    @VerifyToken
    @RequestMapping(value = "/queryByLimitAccountName", method = RequestMethod.GET)
    public Result queryByLimitAccountName(String username, Integer pageIndex, Integer pageSize) {
        return new Result("1001", "查询成功", this.accountService.queryByLimitAccount(username, (pageIndex-1)*pageSize, pageSize), this.accountService.queryByLimitAccountCount(username));
    }

    @VerifyToken
    @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
    public Result deleteAccount(Integer[] ids) {
        return this.accountService.deleteAccount(ids);
    }

    @VerifyToken
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public Result addAccount(String username, String nickname) {
        return this.accountService.addAccount(username, nickname);
    }

    @VerifyToken
    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public Result updateAccount(User user) {
        return this.accountService.updateAccount(user);
    }

    @VerifyToken
    @RequestMapping(value = "/getAccountRight", method = RequestMethod.GET)
    public Result getAccountRight(Integer userId) {
        List<Navigation> navigationList = navigationService.queryAllNavigation();
        List<Right> rightList = accountService.queryRightByUserId(userId);
        Map<String , List> map = new HashMap<>();
        map.put("navigation", navigationList);
        map.put("right", rightList);
        return new Result("1001", "查询成功", map);
    }

    @VerifyToken
    @RequestMapping(value = "/updateAccountRight", method = RequestMethod.POST)
    public Result updateAccountRight(Integer userId, Integer[] checkedValue) {
        return this.accountService.updateAccountRight(userId, checkedValue);
    }
}
