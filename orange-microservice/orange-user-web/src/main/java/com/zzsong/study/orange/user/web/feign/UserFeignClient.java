package com.zzsong.study.orange.user.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by zzsong on 2017/10/14.
 */
@FeignClient(value = "orange-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

}
