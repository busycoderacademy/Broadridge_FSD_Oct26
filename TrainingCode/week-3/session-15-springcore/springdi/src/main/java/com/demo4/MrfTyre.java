package com.demo4;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//<bean id="tyre2" class="com.demo3.MrfTyre"/>
@Component(value = "mrf")
@Profile("test")
public class MrfTyre implements Tyre {
    public void rotate(){
        System.out.println("MrfTyre is used");
    }
}
