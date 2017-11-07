package com.zzsong.study.orange.common.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzsong on 2017/11/6.
 */
public interface AopConstants {

    /**
     * aop获取请求参数时需要获取的参数类型列表
     */
    List<String> ACCEPT_TYPES = new ArrayList<String>() {
        {
            add("java.lang.Integer");
            add("java.lang.Double");
            add("java.lang.Float");
            add("java.lang.Long");
            add("java.lang.Short");
            add("java.lang.Byte");
            add("java.lang.Boolean");
            add("java.lang.Char");
            add("java.lang.String");
            add("int");
            add("double");
            add("long");
            add("short");
            add("byte");
            add("boolean");
            add("char");
            add("float");
            add("com.zzsong.study.orange.common.pojo.table.User");
            add("com.zzsong.study.orange.common.pojo.table.SafetyQuestionAnswer");
            add("com.zzsong.study.orange.common.pojo.table.SafetyQuestion");
            add("com.zzsong.study.orange.common.pojo.table.ReceivingAddress");
            add("com.zzsong.study.orange.common.pojo.table.Province");
            add("com.zzsong.study.orange.common.pojo.table.City");
            add("com.zzsong.study.orange.common.pojo.table.Area");
        }
    };
}
