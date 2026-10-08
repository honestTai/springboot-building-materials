package com.build.service;

import com.build.common.Result;
import com.build.entity.User;

/**
 * (User)表服务接口
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    Result checkUser(String userName, String password);


    Result checkPermission(String token, String navigationRoute);

    Result updatePassword(String token, String oldPassword, String newPassword);
}