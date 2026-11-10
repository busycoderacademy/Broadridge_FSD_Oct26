package com.demo;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoApp {
    private static final Logger logger = LoggerFactory.getLogger(DemoApp.class);

    public static void main(String[] args) {

        logger.info("Hello World");
        logger.debug("code is workng till line no 8");
        logger.debug("code is workng till line no 11");
        try{
            Integer val=Integer.parseInt("a10");
        }catch (Exception e){
            logger.error("Exception occurred",e);
        }
//        System.out.println("Hello World");
//
//
//        System.out.println("code is workng till line no 8");
//
//
//        System.out.println("code is workng till line no 11");
    }
}
