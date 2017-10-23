package com.zzsong.study.orange.common.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;

/**
 * Created by zzsong on 2017/10/13.
 */
public class Result<T> implements Serializable {
    private Integer status;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 200 ok null
     */
    public static <T> Result<T> ok() {
        return new Result<>(200, "ok", null);
    }

    /**
     * 200 msg data
     */
    public static <T> Result<T> ok(String msg, T data) {
        return new Result<>(200, msg, data);
    }

    /**
     * 200 msg null
     */
    public static <T> Result<T> ok(String msg) {
        return new Result<>(200, msg, null);
    }


    /**
     * 204 msg null
     */
    public static <T> Result<T> err(String msg) {
        return new Result<>(400, msg, null);
    }

    /**
     * 204 msg data
     */
    public static <T> Result<T> err(String msg, T data) {
        return new Result<>(400, msg, data);
    }

    public static <T> Result<T> build(Integer status, String msg, T data) {
        return new Result<>(status, msg, data);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
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

}
