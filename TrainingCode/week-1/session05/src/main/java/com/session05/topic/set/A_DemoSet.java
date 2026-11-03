package com.session05.topic.set;

import java.util.HashSet;
import java.util.Set;

public class A_DemoSet {
    public static void main(String[] args) {
        //What is set? various type of set how to use them?
        //Set dont allow duplicate
        //HashSet, LinkedHashSet,TreeSet
        Set<String> set=new HashSet<>();
        System.out.println(set.add("ekta"));;
        set.add("raj");
        set.add("gunika");
        System.out.println( set.add("ekta"));
        System.out.println(set);
    }
}
