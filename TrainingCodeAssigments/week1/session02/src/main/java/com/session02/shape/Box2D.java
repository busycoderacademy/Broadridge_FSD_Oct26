package com.session02.shape;

//Box2D: l,b
 public class Box2D{
    private int l;
    private int b;

    public Box2D(int l, int b){
        this.l=l;
        this.b=b;
    }
    public void show2D(){
        System.out.println("show2D: "+l+" "+b);
    }
    public int getArea(){
        return  l*b;
    }
}
