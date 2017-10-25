package com.zzsong.study.orange.common.util;

/**
 * Created by zzsong on 2017/10/25.
 */
public class RandomUtils {

    /**
     * 获取指定长度的随机数字
     *
     * @param length 长度
     * @return 随机数字
     */
    public static int createRandomNumber(int length) {
        if (length > 9) {
            throw new RuntimeException("最多支持10位随机数!");
        }
        StringBuilder s = new StringBuilder("1");
        for (int i = 0; i < length - 1; i++) {
            s.append("0");
        }
        return (int) ((Math.random() * 9 + 1) * Integer.parseInt(s.toString()));
    }

}
