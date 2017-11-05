package com.zzsong.study.orange.user.configure;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by zzsong on 2017/10/13.
 */
@Configuration
public class MyBatisConfigure {
    @Bean
    @ConditionalOnMissingBean // 当容器没有指定的Bean的情况下创建该对象
    @SuppressWarnings("SpringJavaAutowiringInspection") // 加这个注解让IDE 不报: Could not autowire
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // 设置数据源
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.zzsong.study.orange.common.pojo.table");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 设置mybatis的主配置文件
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis/mybatis-config.xml");
        bean.setConfigLocation(mybatisConfigXml);
        try {
            //添加XML目录
            bean.setMapperLocations(resolver.getResources("classpath:mybatis/mappers/*.xml"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return bean;
    }
}
