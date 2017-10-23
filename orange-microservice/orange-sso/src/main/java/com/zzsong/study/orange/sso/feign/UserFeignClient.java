package com.zzsong.study.orange.sso.feign;

import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.pojo.table.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zzsong on 2017/10/14.
 */
@FeignClient(value = "orangelala-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    Result<String> addUser(@RequestBody User user);

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    Result<User> getUser(@RequestParam("account") String account,
                         @RequestParam("password") String password);

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    Result<String> checkEmail(@RequestBody String email);

    @RequestMapping(value = "/checkPhone", method = RequestMethod.POST)
    Result<String> checkPhone(@RequestBody String phone);
}
