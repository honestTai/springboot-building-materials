package com.build.dao;

import com.build.entity.Right;
import com.build.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 账户相关
 */
@Mapper
public interface AccountDao {

    List<User> queryByLimitAccountName(String username, Integer offset, Integer limit);

    Integer queryByLimitAccountNameCount(@Param("username")String username);

    Integer deleteAccount(Integer[] ids);

    List<Right> queryRightByUserId(Integer userId);

    int deleteAccountRight(Integer userId);

    int insertAccountRight(Integer[] navId, Integer userId);

    int queryPermission(Integer userId, String navigationRoute);
}
