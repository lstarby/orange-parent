package com.zzsong.study.orange.sso.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class FastJsonConfigure {
  /**
   * 使用FastJson解析JSON数据
   *
   * @return HttpMessageConverters
   */
  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters() {
    // 1. 定义一个 Convert 转换消息对象
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    // 2. 添加fastJson配置信息,比如是否格式化返回的Json数据
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(
            SerializerFeature.PrettyFormat,
            SerializerFeature.WriteNullBooleanAsFalse
    );
    // 处理中文乱码问题
    List<MediaType> fastMediaType = new ArrayList<>();
    fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
    fastConverter.setSupportedMediaTypes(fastMediaType);
    // 3. 在Convert中添加配置信息
    fastConverter.setFastJsonConfig(fastJsonConfig);
    // 4. 将Convert添加到converters中并返回
    return new HttpMessageConverters(fastConverter);
  }
}
