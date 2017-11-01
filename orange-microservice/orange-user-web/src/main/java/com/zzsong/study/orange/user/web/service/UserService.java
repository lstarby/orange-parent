package com.zzsong.study.orange.user.web.service;

import com.zzsong.study.orange.common.pojo.Result;
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
}
