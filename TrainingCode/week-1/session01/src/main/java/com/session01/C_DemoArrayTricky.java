package com.session01;
//what is class :aka cookie cutter to create the objects...blueprint
class Dog{
    private String name; //instance varaible
    private int age; //instance varaible
    //parameterized ctr
    public Dog(String dName, int dAge) {
      name=dName;
      age=dAge;
    }
    //Business logic
    public void printDogDetails() {
       System.out.println("Name: "+name+" Age: "+age);
    }
}
public class C_DemoArrayTricky {
    public static void main(String[] args) {
       Dog[] dogs = new Dog[3];//this will create a placeholder where 3 dogs address can be stored
        //but write now no dog is there
        //create 10 dogs
        for(Dog dog: dogs){
            dog.printDogDetails();
        }
    }
}
