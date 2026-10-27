package com.session02.shape;

class DemoShapApp {
    public static void main(String[] args) {
        Box3DWithColor box3DWithColor=new Box3DWithColor(4,5,6,"red");
        box3DWithColor.show3DWithColor();
        System.out.println("Area: "+box3DWithColor.getArea());
        System.out.println("Volume: "+box3DWithColor.getVolume());
    }
}
