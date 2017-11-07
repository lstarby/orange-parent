package com.zzsong.study.orange.user.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zzsong on 2017/10/13.
 */
@Configuration
@EnableTransactionManagement
public class DruidConfigure implements EnvironmentAware {
    private static Logger logger = LoggerFactory.getLogger(DruidConfigure.class);
    private RelaxedPropertyResolver pr;

    @Override
    public void setEnvironment(Environment env) {
        this.pr = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean
    public DataSource dataSource() {
        logger.debug("正在装配Druid");
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(pr.getProperty("url"));
        datasource.setDriverClassName(pr.getProperty("driver-class-name"));
        datasource.setUsername(pr.getProperty("username"));
        datasource.setPassword(pr.getProperty("password"));
        datasource.setInitialSize(Integer.valueOf(pr.getProperty("initialSize")));
        datasource.setMinIdle(Integer.valueOf(pr.getProperty("minIdle")));
        datasource.setMaxWait(Long.valueOf(pr.getProperty("maxWait")));
        datasource.setMaxActive(Integer.valueOf(pr.getProperty("maxActive")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(pr.getProperty("minEvictableIdleTimeMillis")));
        datasource.setTimeBetweenEvictionRunsMillis(Long.valueOf(pr.getProperty("timeBetweenEvictionRunsMillis")));
        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(pr.getProperty("minEvictableIdleTimeMillis")));
        datasource.setValidationQuery(pr.getProperty("validationQuery"));
        datasource.setTestWhileIdle(Boolean.valueOf(pr.getProperty("testWhileIdle")));
        datasource.setTestOnBorrow(Boolean.valueOf(pr.getProperty("testOnBorrow")));
        datasource.setTestOnReturn(Boolean.valueOf(pr.getProperty("testOnReturn")));
        datasource.setPoolPreparedStatements(Boolean.valueOf(pr.getProperty("poolPreparedStatements")));
        datasource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(pr.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        try {
            datasource.setFilters(pr.getProperty("filters"));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        datasource.setConnectionProperties(pr.getProperty("connectionProperties"));
        return datasource;
    }
}
