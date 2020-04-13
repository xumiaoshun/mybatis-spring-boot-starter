package com.rockcode.mybatis.configurations;


import com.alibaba.druid.pool.DruidDataSource;
import com.rockcode.mybatis.properties.MybatisProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(MybatisProperties.class)
public class MybatisAutoConfiguration {

    @Autowired
    private MybatisProperties mybatisProperties;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DruidDataSource driverManagerDataSource = new DruidDataSource();
        driverManagerDataSource.setDriverClassName(mybatisProperties.getDriver());
        driverManagerDataSource.setUrl(mybatisProperties.getUrl());
        driverManagerDataSource.setUsername(mybatisProperties.getUsername());
        driverManagerDataSource.setPassword(mybatisProperties.getPassword());
        return driverManagerDataSource;
    }


}
