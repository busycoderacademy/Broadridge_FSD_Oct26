package com.session3code.ex3;
class Foo{
    void foo(){
        System.out.println("some bad code");
        foo();
    }
}
public class E_SomeCommonEx {
    public static void main(String[] args) {
        //stack overflow error
        Foo foo = new Foo();
        foo.foo();
    }
}
