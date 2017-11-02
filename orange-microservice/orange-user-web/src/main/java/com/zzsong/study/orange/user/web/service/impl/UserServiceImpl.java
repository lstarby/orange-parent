package com.zzsong.study.orange.user.web.service.impl;

import com.zzsong.study.orange.common.constants.RspCode;
import com.zzsong.study.orange.common.constants.SessionConstants;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import com.zzsong.study.orange.common.util.DateUtils;
import com.zzsong.study.orange.user.web.feign.UserFeignClient;
import com.zzsong.study.orange.user.web.service.FileService;
import com.zzsong.study.orange.user.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by zzsong on 2017/10/26.
 */
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final FileService fileService;

    private final UserFeignClient userFeignClient;

    public UserServiceImpl(FileService fileService, UserFeignClient userFeignClient) {
        this.fileService = fileService;
        this.userFeignClient = userFeignClient;
    }

    @Override
    public Result<String> uploadHeadPortrait(MultipartFile file, HttpSession session) {
        User user = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        if (user == null) {
            return Result.err("用户未登录!");
        }
        String userId = user.getUserId();
        String uuid = UUID.randomUUID().toString();
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            String[] split = name.split("\\.");
            String fileName = userId + "-head-portrait-" + uuid;
            int length = split.length;
            if (length > 1) {
                String s = split[length - 1];
                fileName += "." + s;
            }
            byte[] bytes;
            try {
                bytes = file.getBytes();
            } catch (IOException e) {
                log.debug("uploadHeadPortrait throw IOException: {}", e.getMessage());
                return Result.err("头像修改失败!");
            }
            String imgUrl = fileService.uploadHeadPortrait(bytes, fileName);
            User u = new User();
            u.setUserId(userId);
            u.setHeadPortrait(imgUrl);
            Result<String> result = userFeignClient.updateUserByUserId(u, session.getId());
            if (Objects.equals(result.getStatus(), RspCode.SUCC_200)) {
                user.setHeadPortrait(imgUrl);
                session.setAttribute(SessionConstants.SESSION_USER_ATTR, user);
                return Result.ok("头像修改成功", imgUrl);
            } else {
                return Result.err(result.getMsg());
            }
        } else {
            return Result.err("上传文件不合法!");
        }
    }

    @Override
    public Result<User> updateUserInformation(User user, HttpSession session) {
        User sessionUser = (User) session.getAttribute(SessionConstants.SESSION_USER_ATTR);
        if (sessionUser == null) {
            log.debug("get session user returnd null!");
            return Result.err("请重新登录!");
        }
        user.setUserId(sessionUser.getUserId());
        String formattedBirthday = user.getFormattedBirthday();
        if (StringUtils.isNotBlank(formattedBirthday)) {
            try {
                Date birthday = DateUtils.parse(formattedBirthday, "yyyy-MM-dd");
                user.setBirthday(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Result<String> result = userFeignClient.updateUserByUserId(user, session.getId());
        return Result.ok("", new User());
    }

}
