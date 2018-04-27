package com.tango.microdb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:dbconfig/mysql.properties")
public class DataBaseConfiguration {

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql_203_67_3306")
    public DataSource primaryDataSource(){
      return new DruidDataSource();
    }
    
//    @Bean(name = "secondaryDataSource")
//    @Qualifier("secondaryDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.mysql_202_186_3306")
//    public DataSource secondaryDataSource(){
//      return new DruidDataSource(); 
//    }
    
    @Bean(name = "primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

//    @Bean(name = "secondaryJdbcTemplate")
//    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//    }

}
