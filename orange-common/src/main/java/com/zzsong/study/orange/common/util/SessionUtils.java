package com.zzsong.study.orange.common.util;

import com.zzsong.study.orange.common.constants.SessionConstants;

/**
 * Created by zzsong on 2017/10/25.
 */
public class SessionUtils {

    /**
     * 通过存储在cookie中的SessionId生成该session在redis中的key
     *
     * @param CookieSessionId 存储在cookie中的SessionId
     * @return session在redis中的key
     */
    public static String createRedisSessionKey(String CookieSessionId) {
        return "spring:session:" + SessionConstants.REDIS_NAMESPACE + ":sessions:" + CookieSessionId;
    }

    public static String createUserHashKey() {
        return "sessionAttr:" + SessionConstants.SESSION_USER_ATTR;
    }
}
