package com.a;
//default class, package level visibility, this class is private to the package
 public class A {
    public int iPublic=1;
    private int iPrivate=2;
    protected int iProtected=3;
    int iDefault=4;

    public void showApublic(){
        System.out.println("showA public");
    }
    //showA default
    void showAdefault(){
        System.out.println("showA default");
    }
    //showA private
    private void showAprivate(){
        System.out.println("showA private");
    }

    //showA protected
    protected void showAprotected(){
        System.out.println("showA protected");
    }

}
