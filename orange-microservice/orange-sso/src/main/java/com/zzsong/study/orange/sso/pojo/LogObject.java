package com.zzsong.study.orange.sso.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.*;

/**
 * 服务日志对象
 * Created by zzsong on 2017/10/26.
 */
public class LogObject {
    private static final ThreadLocal<OrangeLog> local = ThreadLocal.withInitial(OrangeLog::new);

    public static OrangeLog get() {
        return local.get();
    }

    public static void set(OrangeLog log) {
        local.set(log);
    }

    public static void remove() {
        local.remove();
    }

    @Document(collection = "log-orange-sso")
    @Getter
    @Setter
    @ToString
    public static class OrangeLog implements Serializable {
        /**
         * 日志等级
         */
        private int logLevel;
        /**
         * 响应状态码
         */
        private int rspStatus;
        /**
         * 会话ID
         */
        @Indexed(background = true)
        private String sessionId;
        /**
         * 调用方服务名称
         */
        private String downPlat;
        /**
         * 请求uri
         */
        @Indexed(background = true)
        private String reqUri;
        /**
         * 请求发起方ip地址
         */
        private String reqIp;
        /**
         * 当前服务ip
         */
        private String localIp;
        /**
         * 请求参数列表
         */
        private final Map<String, Object> requestParams = new HashMap<>();
        /**
         * 错误信息
         */
        private final List<String> errMsg = new ArrayList<>();
        /**
         * 响应信息
         */
        private Object response;
        /**
         * 收到请求时的时间戳
         */
        private long reqTime;
        /**
         * 发送响应时的时间戳
         */
        private long rspTime;
        /**
         * 处理耗时
         */
        @Indexed(background = true)
        private long manageTime;
        /**
         * 创建时间, 用于MongoDB TTL索引
         */
        // TODO: 2017/10/27 日志存活时间改为可配置
        @Indexed(expireAfterSeconds = 2592000, background = true)
        private Date createdAt;
    }
}
