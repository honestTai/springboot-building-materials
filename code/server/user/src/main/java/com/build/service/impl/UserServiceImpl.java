package com.build.service.impl;

import com.build.common.Result;
import com.build.common.TokenUtil;
import com.build.dao.AccountDao;
import com.build.dao.NavigationDao;
import com.build.entity.Navigation;
import com.build.entity.Right;
import com.build.entity.User;
import com.build.dao.UserDao;
import com.build.service.AccountService;
import com.build.service.NavigationService;
import com.build.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (User)表服务实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private NavigationDao navigationDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    AccountService accountService;

    @Autowired
    NavigationService navigationService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * @param userName
     * @param password
     * @Description 验证
     * @Exception
     */
    @Override
    public Result checkUser(String userName, String password) {
        User user = userDao.queryByUserName(userName);
        if (user == null) {
            return new Result("2001", "用户不存在");
        }

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            Map<String, Object> map = new HashMap<>();
            Integer userId = accountService.queryByLimitAccount(userName, 0, 1).get(0).getId();
            List<Integer> rightList = accountService.queryRightByUserId(userId).stream().map(Right::getNavigationId).collect(Collectors.toList());
            List<String> navigationList = navigationService.queryAllNavigation().stream().filter(navigation -> {
                return rightList.contains(navigation.getId());
            }).collect(Collectors.toList()).stream().map(navigation -> {
                return navigation.getNavigationRoute().replace("/", "");
            }).collect(Collectors.toList());
            Integer rightCount = navigationService.queryAllNavigation().size();
            navigationList = navigationList.size() == rightCount ? new ArrayList<>() : navigationList;
            map.put("navigationList", navigationList);
            map.put("username", userName);
            map.put("token", TokenUtil.getToken(user.getId().toString(), user.getPassword()));

            return new Result("1001", "登录成功", map);
        } else {
            return new Result("2001", "密码错误");
        }
    }

    @Override
    public Result checkPermission(String token, String navigationRoute) {
        String userId = TokenUtil.getInfoFromToken(token, "id");
        String password = TokenUtil.getInfoFromToken(token, "password");
        if (userId == null || password == null || !TokenUtil.verify(token)) {
            return new Result("3001", "登录已失效，请重新登录");
        }

        int one = this.accountDao.queryPermission(Integer.parseInt(userId), navigationRoute);
        if (one > 0) {
            return new Result("1001", "拥有权限");
        } else {
            return new Result("2001", "非法权限");
        }
    }

    @Override
    public Result updatePassword(String token, String oldPassword, String newPassword) {

        String userId = TokenUtil.getInfoFromToken(token, "id");
        String password = TokenUtil.getInfoFromToken(token, "password");
        if (userId == null || password == null || !TokenUtil.verify(token)) {
            return new Result("3001", "登录已失效，请重新登录");
        }

        // 先去验证原密码正确与否
        User user = this.userDao.queryById(Integer.parseInt(userId));
        if (user != null) {
            // 原密码验证正确
            if (bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
                newPassword = bCryptPasswordEncoder.encode(newPassword);
                User newUser = new User();
                newUser.setId(Integer.parseInt(userId));
                newUser.setPassword(newPassword);
                if (this.userDao.update(newUser) == 1) {
                    return new Result("1001", "修改成功，请重新登录");
                } else {
                    return new Result("2001", "修改失败");
                }
            } else {
                return new Result("2001", "原密码错误");
            }
        } else {
            return new Result("3001", "登录已失效，请重新登录");
        }
    }
}