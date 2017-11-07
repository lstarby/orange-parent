package com.zzsong.study.orange.user.web.feign;

import com.zzsong.study.orange.common.constants.SessionConstants;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zzsong on 2017/10/14.
 */
@FeignClient(value = "orange-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    /**
     * 通过userid更新用户数据
     *
     * @param user      用户对象
     * @param sessionId sessionId
     * @return Result<String>
     */
    @RequestMapping(value = "/updateUserByUserId", method = RequestMethod.POST)
    Result<String> updateUserByUserId(@RequestBody User user,
                                      @RequestHeader(SessionConstants.SESSION_ID_HEADER) String sessionId);

    /**
     * 通过userId获取用户对象
     *
     * @param userId    用户ID
     * @param sessionId sessionId
     * @return Result<User>
     */
    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.POST)
    Result<User> getUserByUserId(@RequestParam("userId") String userId,
                                 @RequestHeader(SessionConstants.SESSION_ID_HEADER) String sessionId);

    /**
     * 修改密码
     *
     * @param user        (password+(userid | phone | email))
     * @param newPassword 新密码
     * @param sessionId   sessionId
     * @return Result<String>
     */
    Result<String> changePassword(@RequestBody User user,
                                  @RequestParam("newPassword") String newPassword,
                                  @RequestHeader(SessionConstants.SESSION_ID_HEADER) String sessionId);
}
