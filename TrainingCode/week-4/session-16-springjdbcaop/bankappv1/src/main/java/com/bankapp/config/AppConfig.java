package com.bankapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@ComponentScan(basePackages = "com.bankapp")
@EnableAspectJAutoProxy
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class AppConfig {
    //i need to create infra str beans Connection

    @Value(("${database.url}"))
    private String url;

    @Value(("${database.driver}"))
    private String driverName;

    @Value(("${database.username}"))
    private String username;

    @Value(("${database.password}"))
    private String password;

    //DataSource support connection pool , better perforamce of app
    @Bean
    public DataSource connectionFactroy(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverName);
        return dataSource;
    }
    //bean for jdbctemplate
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return  new JdbcTemplate(dataSource);
    }
    //Spring provide jdbc Tx mgt
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
