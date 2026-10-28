package com.b;
import com.a.A;
//the main differ bw defualt and protected is that default is visible only within the package
//whereas protected is visible within the package and also outside the package,
//iff we subclass in into another package
public class B extends A{
    public static void main(String[] args) {
       B b=new B();
        System.out.println(b.iProtected);
//        System.out.println(b.iDefault);
//       b.showAdefault();
       b.showAprotected();




//       A a=new A();
//        System.out.println(a.iPublic);
//        a.showApublic();
    }
}
