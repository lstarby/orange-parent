package com.zzsong.study.orange.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 新增的时间操作工具,经压测该工具的效率约是之前的DateUtil工具类的5倍
 * Created by zzsong on 2017/8/18.
 */
public class DateUtils {

  /**
   * 该类只提供静态方法,无需创建实例
   */
  private DateUtils() {
  }

  private static final Object LOCK_OBJ = new Object();

  /**
   * 存放不同的日期模板格式的sdf的Map
   * ThreadLocal为每个线程创建一个SimpleDateFormat局部变量,因此不存在线程安全问题
   */
  private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

  /**
   * 根据模式串从sdfMap中获取一个SimpleDateFormat实例
   *
   * @param pattern 模式串
   * @return SimpleDateFormat实例
   */
  private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
    ThreadLocal<SimpleDateFormat> threadLocal = sdfMap.get(pattern);
    // 双重判断防止sdfMap中put重复的value
    if (threadLocal == null) {
      synchronized (LOCK_OBJ) {
        threadLocal = sdfMap.get(pattern);
        if (threadLocal == null) {
          threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat(pattern));
          sdfMap.put(pattern, threadLocal);
        }
      }
    }
    return threadLocal.get();
  }


  /**
   * Date转换为时间字符串
   *
   * @param date    Date
   * @param pattern 模式串 如<code>yyyy-MM-dd</code>
   * @return String 时间字符串 如<code>2017-01-01</code>
   */
  public static String format(Date date, String pattern) {
    if (date == null || StringUtils.isBlank(pattern)) {
      return null;
    }
    return getSimpleDateFormat(pattern).format(date);
  }

  /**
   * 时间字符串转换为Date
   *
   * @param dateString 时间戳 如<code>1483200000000</code>
   * @param pattern    模式串 如<code>yyyy-MM-dd</code>
   * @return Date
   * @throws ParseException SimpleDateFormat解析异常
   */
  public static Date parse(String dateString, String pattern) throws ParseException {
    if (StringUtils.isBlank(dateString) || StringUtils.isBlank(pattern)) {
      return null;
    }
    return getSimpleDateFormat(pattern).parse(dateString);
  }

  /**
   * 将时间戳转换为时间字符串
   *
   * @param timestamp 时间戳 如<code>1483200000000</code>
   * @param pattern   模式串 如<code>yyyy-MM-dd</code>
   * @return String 时间字符串 如<code>2017-01-01</code>
   */
  public static String format(long timestamp, String pattern) {
    return format(new Date(timestamp), pattern);
  }

  /**
   * 时间戳转换为时间字符串
   *
   * @param timestamp 时间戳 如<code>1483200000000</code>
   * @param pattern   模式串 如<code>yyyy-MM-dd</code>
   * @return String 时间字符串 如<code>2017-01-01</code>
   * @throws NumberFormatException NumberFormatException
   */
  public static String format(String timestamp, String pattern) throws NumberFormatException {
    if (StringUtils.isBlank(timestamp)) {
      return null;
    }
    long time = Long.parseLong(timestamp);
    return format(time, pattern);
  }

  /**
   * 将时间字符串转换为时间戳
   *
   * @param dateString 时间字符串 如<code>2017-01-01</code>
   * @param pattern    模式串 如<code>yyyy-MM-dd</code>
   * @return 时间戳 如<code>1483200000000</code>
   * @throws ParseException SimpleDateFormat解析异常
   */
  public static Long getTimestamp(String dateString, String pattern) throws ParseException {
    Date parse = parse(dateString, pattern);
    return parse == null ? null : parse.getTime();
  }
}