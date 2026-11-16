package com.demo4;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// <bean id="tyre1" class="com.demo3.CeatTyre" primary=true/>
@Component(value = "ceat")
@Profile("dev")
public class CeatTyre implements Tyre {
    public void rotate(){
        System.out.println("CeatTyre is used");
    }
}
