package com.zzsong.study.orange.user.mapper;

import com.zzsong.study.orange.common.pojo.table.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzsong on 2017/10/13.
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user User Object
     * @return 插入的条数
     */
    int addUser(User user);

    /**
     * 通过(手机+密码 | 邮箱+密码 | userId+密码)的组合获取用户数据
     *
     * @param user (password+(userid | phone | email))
     * @return List<User>
     */
    List<User> getUser(User user);

    /**
     * 验证(手机 | 邮箱是否已经存在)
     * 判断条件为<code>phone = #{phone} or email = #{email}</code>
     * 这个方法不会验证手机和邮箱同时满足的条件
     * 当只设置邮箱或手机时可用于验证手机或邮箱是否已经存在
     * 当手机和邮箱都是相同的值时可验该账号是否已经存在
     *
     * @param user user.phone | user.email
     * @return 符合条件的数量
     */
    int checkUser(User user);
}
