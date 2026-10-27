package com.session01;
public class A_HelloWorld {
    public static void main( String[] args ) {

        //Arrays: continus memory allocation, arrays are object in java
        int []arr= {3,5,6,6,78,77};
        for(int i: arr){
            System.out.println(i);
        }

//        for(int i=0;i<=arr.length; i++){
//            System.out.println(arr[i]);
//        }




        //looping arrays if else
        //for loop to iterate 1 to 20
        //find nos of even no bw 1 to 20
        //int counter = getEvenNumbers();
       // System.out.println("Number of even numbers between 1 and 20: " + counter);



    }


    private static int getEvenNumbers() {
        int counter=0;
        for(int i=1;i<=20;i++){
            if(i%2==0){
                counter++;
            }
        }
        return counter;
    }
}
