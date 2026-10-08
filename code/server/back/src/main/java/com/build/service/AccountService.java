package com.build.service;

import com.build.common.Result;
import com.build.entity.Right;
import com.build.entity.User;

import java.util.List;

/**
 * 账户服务
 */
public interface AccountService {

    List<User> queryByLimitAccount(String username, Integer offset, Integer limit);

    Integer queryByLimitAccountCount(String username);

    Result deleteAccount(Integer[] ids);

    Result addAccount(String username, String nickname);

    Result updateAccount(User user);

    List<Right> queryRightByUserId(Integer userId);

    Result updateAccountRight(Integer userId, Integer[] checkedValue);
}
