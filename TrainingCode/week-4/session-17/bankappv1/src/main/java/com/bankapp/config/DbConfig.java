package com.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.bankapp")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DbConfig {
    //infra bean for conn factory jdbc: singleton factory
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${database.driver}")
    private String driverName;

    @Bean
    //@Scope("singleton")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driverName);
        return  dataSource;
    }
    //JdbcTemplate aka template design pattern impl for jdbc, kafkatempalte
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        return  jdbcTemplate;
    }
    //spring is not doing tx  mgt spring delegete it to the underlying tech eg jdbc  jpa spring tx is aka wrapper
    //so that we can ejoy tx mgt writing explict code : spring aop
    @Bean
    public JdbcTransactionManager jdbcTransactionManager(DataSource dataSource){
        return new JdbcTransactionManager(dataSource);
    }

}
