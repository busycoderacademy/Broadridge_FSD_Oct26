package com.session02;
//Box2D: l,b
class Box2D{
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
//Box3D : h
class Box3D extends  Box2D{
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
//Box3DWithColor: color
 class Box3DWithColor extends  Box3D{
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

 public class D_BoxExample {
    public static void main(String[] args) {
        Box3DWithColor box3DWithColor=new Box3DWithColor(4,5,6,"red");
        box3DWithColor.show3DWithColor();
        System.out.println("Area: "+box3DWithColor.getArea());
        System.out.println("Volume: "+box3DWithColor.getVolume());
    }
}
