package com.session3code.ex3;

import java.io.FileNotFoundException;
import java.io.IOException;

class M{
    public M()throws IOException{
        System.out.println("M");
    }
}

//so ctr of derived class  can not throw smaller  ex in heriarachy?
class N extends M{
    public N() throws Exception{
        super();
        System.out.println("N");
    }
}
public class G2_ExHandlingInCtr {
    public static void main(String[] args) {
//        A a=new B();
//        a.foo();
    }
}
