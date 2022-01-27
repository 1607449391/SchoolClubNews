package com.ssm.schoolclubnews.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
 *@author：
 *@time：2022-01-16 16:57
 *@description：
 *
 */
@Configuration
public class DruidDataSourceConfig {
    /**
     * 使用durid作为数据库连接池
     *
     * @return druid数据源
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}
