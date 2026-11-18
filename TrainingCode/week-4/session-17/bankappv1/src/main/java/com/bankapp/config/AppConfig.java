package com.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

//This class is passed to application context
@Configuration
@ComponentScan(basePackages = "com.bankapp")
@Import(DbConfig.class)
@EnableAspectJAutoProxy //hey spring dont forget u have to support aop
public class AppConfig {
}
