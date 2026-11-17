package com.demo4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
        <context:annotation-config/><!--hey spring i will go with annotation -->
        <context:component-scan base-package="com.demo3"/> <!--hey spring look into this package -->

 */
@Configuration //<context:annotation-config/> this class is a config class: bootstrap class
@ComponentScan(basePackages = "com.demo4")
public class AppConfig {
}
