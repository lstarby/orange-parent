package com.zzsong.study.orange.user.web.feign;

import com.zzsong.study.orange.common.constants.SessionConstants;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zzsong on 2017/10/14.
 */
@FeignClient(value = "orange-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/updateUserByUserId", method = RequestMethod.POST)
    Result<String> updateUserByUserId(@RequestBody User user,
                                      @RequestHeader(SessionConstants.SESSION_ID_HEADER) String sessionId);
}
