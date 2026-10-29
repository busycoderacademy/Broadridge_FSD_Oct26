package com.session3code.ex3;

import java.io.FileNotFoundException;
import java.io.IOException;

class A{
    public void foo()throws IOException {
        System.out.println("foo of class A");
    }
}

//Overriden method can not throw bigger ex in heriarachy?
class B extends A{
    public void foo() throws FileNotFoundException {
        System.out.println("foo of class B");
    }
}
public class G_ExHandlingInOverriding {
    public static void main(String[] args) {
//        A a=new B();
//        a.foo();
    }
}
