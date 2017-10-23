package com.zzsong.study.orange.user.mapper;

import com.zzsong.study.orange.common.pojo.table.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzsong on 2017/10/13.
 */
public interface UserMapper {
    int addUser(User user);

    List<User> getUser(@Param("account") String account, @Param("password") String password);
}
