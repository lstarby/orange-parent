package com.zzsong.study.orange.user.web.util;


import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzsong on 2017/10/26.
 */
public class AopUtils {

    /**
     * 通过反射机制 获取被切参数名以及参数值
     *
     * @param cls        切面Class <code>this.getClass()</code>
     * @param clazzName  连接点的类名 <code>joinPoint.getTarget().getClass().getName();</code>
     * @param methodName 连接点方法名称 <code>joinPoint.getSignature().getName()</code>
     * @param args       连接点请求参数 <code>joinPoint.getArgs()</code>
     * @param types      需要获取的参数类型列表 如:{"java.lang.Integer", "java.lang.Double"}
     * @return 参数列表
     */
    public static Map<String, Object> getFields(Class cls,
                                                String clazzName,
                                                String methodName,
                                                Object[] args,
                                                List<String> types) throws NotFoundException {
        Map<String, Object> map = new HashMap<>();
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);
        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr
                = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            return map;
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            String key = attr.variableName(i + pos);
            Object arg = args[i];
            if (arg != null) {
                String typeName = arg.getClass().getTypeName();
                if (types.contains(typeName)) {
                    map.put(key, arg);
                    break;
                }
            }
        }
        return map;
    }
}
