package com.java8.session1.ex3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

//SOLID: OCP
public class AppleApp {
    public static List<Apple>getAppleOnPredicate(List<Apple> apples, Predicate<Apple> filter) {
      return apples.stream().filter(filter).collect(toList());
    }

//    public static List<Apple>heavyApples(List<Apple> apples){
//        //java 7 ways
//        List<Apple> heavyApples=new ArrayList<>();
//        for(Apple apple: apples){
//            if(apple.getWeight()>=250){
//                heavyApples.add(apple);
//            }
//        }
//        return  heavyApples;
//    }
//    public static List<Apple>greenApples(List<Apple> apples){
//        //java 7 ways
//        List<Apple> greenApples=new ArrayList<>();
//        for(Apple apple: apples){
//            if(apple.getColor().equals("green")){
//                greenApples.add(apple);
//            }
//        }
//        return  greenApples;
//    }
}




