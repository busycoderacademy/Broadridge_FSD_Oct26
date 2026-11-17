package com.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.demo")
@EnableAspectJAutoProxy //hey spring i want to integrate u with aspectJ
public class AppConfig {
}
