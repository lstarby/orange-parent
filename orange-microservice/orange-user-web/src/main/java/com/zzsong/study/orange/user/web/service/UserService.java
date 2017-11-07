package com.zzsong.study.orange.user.web.service;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by zzsong on 2017/10/26.
 */
public interface UserService {
    /**
     * 修改用户头像
     *
     * @param session HttpSession
     * @param file    头像文件
     * @return Result<String>
     */
    Result<String> uploadHeadPortrait(MultipartFile file, HttpSession session);

    Result<User> updateUserInformation(User user, HttpSession session);

    /**
     * 修改密码
     *
     * @param password    旧密码
     * @param newPassword 新密码
     * @param session     session
     * @return Result<String>
     */
    Result<String> changePassword(String password, String newPassword, HttpSession session);
}
