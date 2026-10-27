package com.session02;
class Player{
    private int id;
    private String name;
    private int rating;
    static private int counter;

    //callled only once at the time of class loading
    static {
        counter=0;
        System.out.println("static init block"); //DRY (dont repeat urself)
    }
    //init block in java
    {
        System.out.println("some common code 1"); //DRY (dont repeat urself)
    }
    {
        System.out.println("some common code 2"); //DRY (dont repeat urself)
    }

    public Player(){
        this("ABC",0);
    }
    public Player(String name, int rating){
        System.out.println("ctr call");
        this.id=++counter;
        this.name=name;
        this.rating=rating;
    }

    public void display(){
        System.out.println("Player ID: " + id);
        System.out.println("Player Name: " + name);
        System.out.println("Player Rating: " + rating);
    }
    //static method can be called without object: class method
    //this pointer or ref is not available inside static method
    public static void displayCounter(){
        System.out.println("Counter: " + counter);
    }
}
public class A_HelloClass {
    public static void main(String[] args) {
//       Player player1=new Player("ravi",100); //static class loading

        //Dymanic class loading*
        try {
            Class.forName("com.session02.Player");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
