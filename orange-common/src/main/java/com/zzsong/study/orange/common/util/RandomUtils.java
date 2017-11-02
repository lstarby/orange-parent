package com.zzsong.study.orange.common.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by zzsong on 2017/10/25.
 */
public class RandomUtils {

    /**
     * 获取指定长度的随机数字
     * 如length为2, 则返回10~99的随机数
     *
     * @param length 长度
     * @return 随机数字
     */
    public static int createRandomNumbeBySpecifiedLength(int length) {
        if (length <= 0) {
            throw new RuntimeException("length不能小于1!");
        }
        if (length > 9) {
            throw new RuntimeException("最多支持9位随机数!");
        }
        int max, min;
        if (length == 1) {
            min = 0;
            max = 10;
        } else {
            StringBuilder sb = new StringBuilder(length);
            sb.append(1);
            for (int i = 0; i < length - 1; i++) {
                sb.append(0);
            }
            min = Integer.valueOf(sb.toString());
            max = min * 10;
        }
        return createRandomNumbeInSpecifiedection(min, max);
    }

    /**
     * 获取指定区间的随机数(不包括max) min <= value < max
     * 如 min=10 max=100, 则返回10~99的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    public static int createRandomNumbeInSpecifiedection(int min, int max) {
        return createRandomNumbe(max) % (max - min + 1) + min;
    }

    /**
     * 获取0~max之间的随机数(不包括max) 0 <= value < max
     *
     * @param max 最大值
     * @return 随机数字
     */
    public static int createRandomNumbe(int max) {
        return ThreadLocalRandom.current().nextInt(max);
    }
}
