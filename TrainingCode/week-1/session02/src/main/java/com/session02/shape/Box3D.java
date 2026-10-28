package com.session02.shape;

//Box3D : h
public class Box3D extends  Box2D{
    private int h;
    public Box3D(int l, int b, int h){
        super(l,b);
        this.h=h;
    }
    public int getVolume(){
        return getArea()*h;
    }
    public void show3D(){
        show2D();
        System.out.println("show3D: "+h);
    }
}
