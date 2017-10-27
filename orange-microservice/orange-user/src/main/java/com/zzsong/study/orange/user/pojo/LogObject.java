package com.zzsong.study.orange.user.pojo;

import com.alibaba.fastjson.JSON;
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

    @Document(collection = "log-orange-user")
    public static class OrangeLog implements Serializable {
        /**
         * 日志等级
         */
        private int logLevel;
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
         * 方法名称
         */
        @Indexed(background = true)
        private String method;
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

        public int getLogLevel() {
            return logLevel;
        }

        public void setLogLevel(int logLevel) {
            this.logLevel = logLevel;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getDownPlat() {
            return downPlat;
        }

        public void setDownPlat(String downPlat) {
            this.downPlat = downPlat;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getReqIp() {
            return reqIp;
        }

        public void setReqIp(String reqIp) {
            this.reqIp = reqIp;
        }

        public String getLocalIp() {
            return localIp;
        }

        public void setLocalIp(String localIp) {
            this.localIp = localIp;
        }

        public Map<String, Object> getRequestParams() {
            return requestParams;
        }

        public List<String> getErrMsg() {
            return errMsg;
        }

        public Object getResponse() {
            return response;
        }

        public void setResponse(Object response) {
            this.response = response;
        }

        public long getReqTime() {
            return reqTime;
        }

        public void setReqTime(long reqTime) {
            this.reqTime = reqTime;
        }

        public long getRspTime() {
            return rspTime;
        }

        public void setRspTime(long rspTime) {
            this.rspTime = rspTime;
        }

        public long getManageTime() {
            return manageTime;
        }

        public void setManageTime(long manageTime) {
            this.manageTime = manageTime;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
