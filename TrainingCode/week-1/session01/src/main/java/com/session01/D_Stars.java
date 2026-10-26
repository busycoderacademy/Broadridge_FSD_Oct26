package com.session01;

import java.util.Scanner;

public class D_Stars {
    public static void main(String[] args) {
        //how to take input from the user?
        Scanner scanner=new Scanner(System.in);
        int noOfStars=scanner.nextInt();
        System.out.println("no of stars: "+noOfStars);
        printstars(noOfStars);


    }

    //user will pass no of stars in this program and then do it
    private static void printstars(int noOfStars) {
        for(int i=0;i<noOfStars;i++){
            for(int k=noOfStars-1;k>i; k--)
                System.out.print(" ");
            for(int j=0;j<(i*2+1);j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
