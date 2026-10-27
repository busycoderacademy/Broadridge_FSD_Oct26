package com.session02.shape;

public class Box3DWithColor extends  Box3D{
    private String color;
    public Box3DWithColor(int l, int b,int h, String color){
        super(l, b ,h);
        this.color=color;
    }
    public void show3DWithColor(){
        show3D();
        System.out.println("show3DWithColor: "+color);
    }
}
