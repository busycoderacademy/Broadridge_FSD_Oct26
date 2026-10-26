package com.session01;

public class B_NextDate {
    public static void main(String[] args) {
        //find wether year is a leap year or not?
        int year = 2026;
        int month =12;
        int day=31;
        System.out.println("date before increase: "+day+"/"+month+"/"+year);
        boolean isLeap=isLeapYear(year);
        //we wnat to create a array to how max days in a month
        int[] daysInMonth = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeap) {
            daysInMonth[2] = 29;
        }
        //finding next date
        day=day+1;
        if (day>daysInMonth[month]) {
            day=1;
            month++;
            if (month>12) {
                month=1;
                year++;
            }
        }
        System.out.println("date after increase: "+day+"/"+month+"/"+year);

    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYear=false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            isLeapYear=true;
        }
        return isLeapYear;
    }
}
