package com.session02;
class A{
    private int i;

    public A(int i){
        this.i=i;
    }
    public void showA(){
        System.out.println("showA: "+i);
    }
    public int getI(){
        return i;
    }
}
class  B extends  A{
    private  int j;
    public B(int i, int j){
        super(i);
        this.j=j;
    }
    public void showB(){
        System.out.println(getI());
        System.out.println("showB: "+j);
        showA();
    }

}
public class C_Inheritance {
    public static void main(String[] args) {
        B b=new B(1,2);
        b.showB();
    }
}
