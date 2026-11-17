package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
     Magician magician2=new Magician();
        System.out.println(magician2.getClass());
//    magician.doMagic();
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfig.class);
        Magician magician=ctx.getBean("magician",Magician.class);
        System.out.println(magician.getClass());
        magician.doCalculatePerformance();
//        magician.doMagic();
//        magician.doEating();

    }
}
