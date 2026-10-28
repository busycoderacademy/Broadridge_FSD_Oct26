package com.a;

public class X {
    public static void main(String[] args) {
        A a=new A();
        System.out.println(a.iPublic);
        a.showApublic();
        System.out.println(a.iProtected);
        a.showAprotected();
        System.out.println(a.iDefault);
        a.showAdefault();
//        System.out.println(a.iPrivate);
//        a.showAprivate();
    }
}
