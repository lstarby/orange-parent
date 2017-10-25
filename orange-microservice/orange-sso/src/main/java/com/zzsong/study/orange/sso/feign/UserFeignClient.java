package com.zzsong.study.orange.sso.feign;

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
     * 新增用户
     *
     * @param user User
     * @return Result<String>
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    Result<String> addUser(@RequestBody User user);

    /**
     * 查询用户
     *
     * @param account  账号(邮箱 手机)
     * @param password 密码
     * @return Result<User>
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    Result<User> getUser(@RequestParam("account") String account,
                         @RequestParam("password") String password);

    /**
     * 判断邮箱是否可用
     *
     * @param email 邮箱
     * @return 200:可用,邮箱不存在 400:不可用,邮箱已存在
     */
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    Result<String> checkEmail(@RequestParam("email") String email);

    /**
     * 判断手机号码是否可用
     *
     * @param phone 手机号码
     * @return 200:可用,手机不存在 400:不可用,手机已存在
     */
    @RequestMapping(value = "/checkPhone", method = RequestMethod.POST)
    Result<String> checkPhone(@RequestParam("phone") String phone);
}
