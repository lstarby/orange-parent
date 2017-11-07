package com.zzsong.study.orange.common.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zzsong.study.orange.common.constants.RspCode;
import lombok.*;

import java.io.Serializable;

/**
 * Created by zzsong on 2017/10/13.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer status;
    private String msg;
    private T data;

    /**
     * 200 ok null
     */
    public static <T> Result<T> ok() {
        return new Result<>(RspCode.SUCC_200, "ok", null);
    }

    /**
     * 200 msg data
     */
    public static <T> Result<T> ok(String msg, T data) {
        return new Result<>(RspCode.SUCC_200, msg, data);
    }

    /**
     * 200 msg null
     */
    public static <T> Result<T> ok(String msg) {
        return new Result<>(RspCode.SUCC_200, msg, null);
    }

    /**
     * 200 ok data
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(RspCode.SUCC_200, "ok", data);
    }

    /**
     * 400 msg null
     */
    public static <T> Result<T> err(String msg) {
        return new Result<>(RspCode.ERR_400, msg, null);
    }

    /**
     * 400 msg data
     */
    public static <T> Result<T> err(String msg, T data) {
        return new Result<>(RspCode.ERR_400, msg, data);
    }

    public static <T> Result<T> build(Integer status, String msg, T data) {
        return new Result<>(status, msg, data);
    }

    public static <T> Result<T> parse(String text, Class<T> clazz) {
        Result<T> result = JSON.parseObject(text, new TypeReference<Result<T>>() {
        });
        T data = result.getData();
        if (data != null && !(data instanceof String)) {
            T t = JSON.parseObject(data.toString(), clazz);
            result.setData(t);
        }
        return result;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
