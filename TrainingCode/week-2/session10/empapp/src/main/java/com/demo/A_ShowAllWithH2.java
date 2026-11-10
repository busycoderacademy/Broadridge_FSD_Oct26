package com.demo;
import java.sql.*;

public class A_ShowAllWithH2 {
    public static void main(String[] args) {

      //load the driver
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("driver is loaded");
//        }catch (ClassNotFoundException e){
//            System.out.println("driver is not loaded");
//        }
        //get a connection object
        try{
            Connection connection=DriverManager
                    .getConnection("jdbc:h2:~/companydb","sa","");

            Statement stmt=connection.createStatement();
            //executeQuery: rs vs executeUpdate: alwasy give me no of tuple effectd
            ResultSet resultSet = stmt.executeQuery("select * from demp");

            System.out.println("conn is done");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
