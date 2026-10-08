package com.build.service.impl;

import com.build.common.Result;
import com.build.dao.AccountDao;
import com.build.dao.UserDao;
import com.build.entity.Right;
import com.build.entity.User;
import com.build.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户相关服务接口实现
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private UserDao userDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<User> queryByLimitAccount(String username, Integer offset, Integer limit) {
        return this.accountDao.queryByLimitAccountName(username, offset, limit);
    }

    @Override
    public Integer queryByLimitAccountCount(String username) {
        return this.accountDao.queryByLimitAccountNameCount(username);
    }

    @Override
    public Result deleteAccount(Integer[] ids) {
        if (this.accountDao.deleteAccount(ids) == ids.length) {
            return new Result("1001", "删除成功");
        }
        return new Result("2001", "删除失败");
    }

    @Override
    public Result addAccount(String username, String nickname) {
        User oldUser = this.userDao.queryByUserName(username);
        if (oldUser != null) {
            return new Result("2001", "该账户已存在");
        }
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(bCryptPasswordEncoder.encode("123456"));
        int answer = this.userDao.insert(user);

        if (answer == 1) {
            return new Result("1001", "注册成功，初始密码为123456");
        } else {
            return new Result("2001", "注册失败");
        }
    }

    @Override
    public Result updateAccount(User user) {
        User oldUser = this.userDao.queryByUserNameNotSelf(user.getUsername(), user.getId());
        if (oldUser != null) {
            return new Result("2001", "该账户已存在");
        }

        if (user.getPassword() != null && !user.getPassword().equals("")) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        int one = this.userDao.update(user);

        if (one == 1) {
            return new Result("1001", "修改成功");
        } else {
            return new Result("2001", "修改失败");
        }
    }

    @Override
    public List<Right> queryRightByUserId(Integer userId) {
        return this.accountDao.queryRightByUserId(userId);
    }

    @Override
    public Result updateAccountRight(Integer userId, Integer[] checkedValue) {
        this.accountDao.deleteAccountRight(userId);
        int one = this.accountDao.insertAccountRight(checkedValue, userId);
        if (one == checkedValue.length) {
            return new Result("1001", "授权成功");
        } else {
            return new Result("2001", "授权失败");
        }
    }
}
