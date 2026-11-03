package com.java8.session1.ex0.interface_evolutions;

//interface X{
//    void f1();
//    default  void f2(){
//        System.out.println("f2 of interface X");
//    }
//    static void fooStatic(){
//        System.out.println("fooStatic of interface X");
//    }
////    default void foof(){
////        System.out.println("foof of interface X");
////    }
//}
//class XImpl implements X{
//
//    @Override
//    public void f1() {
//        System.out.println("f1 of interface X is overriden");
//    }
//}
interface X{
    default void foof(){
        System.out.println("foof of interface X");
    }
}
interface Y{
    default void foof(){
        System.out.println("foof of interface Y");
    }
}

class M implements X, Y{
    public void foof(){
        System.out.println("foof of interface X or Y is overriden");
    }
}
public class A1_InterfaceEvolutionDiamondProblem {
    public static void main(String[] args) {
//        X x=new XImpl();
//        x.f1();
//        x.f2();
//        X.fooStatic();

    }
}
