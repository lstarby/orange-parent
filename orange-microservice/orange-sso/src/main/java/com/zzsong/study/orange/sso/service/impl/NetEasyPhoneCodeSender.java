package com.zzsong.study.orange.sso.service.impl;

import com.alibaba.fastjson.JSON;
import com.zzsong.study.orange.common.constants.RspCode;
import com.zzsong.study.orange.common.pojo.Result;
import com.zzsong.study.orange.common.util.SHA1Encod;
import com.zzsong.study.orange.sso.service.PhoneCodeSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by zzsong on 2017/10/24.
 */
public class NetEasyPhoneCodeSender implements PhoneCodeSender {
    private static Logger logger = LoggerFactory.getLogger(NetEasyPhoneCodeSender.class);

    private final RestTemplate template;

    //发送验证码的请求路径URL
    private static final String
            SERVER_URL = "https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String
            APP_KEY = "0be6d378466a7c3994bc2d0b29c66fdd";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET = "b539ea3c9a3c";
    //随机数
    private static final String NONCE = "123456";
    //短信模板ID
    private static final String TEMPLATEID = "3057527";
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN = "6";

    public NetEasyPhoneCodeSender(RestTemplate template) {
        this.template = template;
    }

    @Override
    public Result<String> send(String phone) {
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = SHA1Encod.encode(APP_SECRET + NONCE + curTime);

        // 设置请求头
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("AppKey", APP_KEY);
        requestHeaders.add("Nonce", NONCE);
        requestHeaders.add("CurTime", curTime);
        requestHeaders.add("CheckSum", checkSum);
        requestHeaders.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        // 设置请求body
        MultiValueMap<String, Object> postData = new LinkedMultiValueMap<>();
        // ?mobile=phone&codeLen=CODELEN
        postData.add("mobile", phone);
        postData.add("codeLen", CODELEN);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(postData, requestHeaders);

        ResponseEntity<NetEasyPhoneCodeRsp> rsp = template.exchange(SERVER_URL,
                HttpMethod.POST, httpEntity, NetEasyPhoneCodeRsp.class);
        if (rsp == null) {
            return Result.err("Response from NetEasy is null");
        }
        NetEasyPhoneCodeRsp body = rsp.getBody();
        logger.debug("phoneCodeSender rsp body = {}", body == null ? "null" : body.toString());
        if (body == null) {
            return Result.err("rsp.getBody() is null!");
        } else {
            if (!Objects.equals(body.code, RspCode.SUCC_200)) {
                return Result.err(body.msg);
            } else {
                return Result.ok(body.msg, body.obj);
            }
        }
    }

    @Override
    public Result<String> send(String phone, String code) {
        throw new RuntimeException("NetEasyPhoneCodeSender 不支持此方法!");
    }

    public static class NetEasyPhoneCodeRsp {
        private Integer code;
        private String msg;
        private String obj;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getObj() {
            return obj;
        }

        public void setObj(String obj) {
            this.obj = obj;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

    public static class NetEasyPhoneCodeReq {
        private String mobile;
        private String codeLen;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCodeLen() {
            return codeLen;
        }

        public void setCodeLen(String codeLen) {
            this.codeLen = codeLen;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }

}