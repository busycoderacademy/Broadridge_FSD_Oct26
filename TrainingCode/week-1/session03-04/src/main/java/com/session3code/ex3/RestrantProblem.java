package com.session3code.ex3;
class Food{
    private String type;
    public Food(String type) {
        this.type = type;
    }
    public void print(){
        System.out.println("Food  is :"+type);
    }
}
class PaneerNotAvailableException extends RuntimeException{
    public PaneerNotAvailableException(String message) {
        super(message);
    }
}

public class RestrantProblem {
    public static void main(String[] args) {
        waiter();
    }

    private static void waiter() {
       try{
           Food food= cook();
           food.print();
       }catch (PaneerNotAvailableException ex){
           Food food=new Food("Mutton");
           food.print();
       }

    }

    private static Food cook() {
            //cook start cooking the food
            throw new PaneerNotAvailableException("Paneer is not available");

    }
}
