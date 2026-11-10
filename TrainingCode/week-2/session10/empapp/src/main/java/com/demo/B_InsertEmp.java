package com.demo;
import java.sql.*;

public class B_InsertEmp {
    public static void main(String[] args) {

      //load the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver is loaded");
        }catch (ClassNotFoundException e){
            System.out.println("driver is not loaded");
        }
        //get a connection object
        Connection connection=null;
        try{
             connection=DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bankappraj?useSSL=false",
                            "root","root");
            PreparedStatement pstmt=connection.
                    prepareStatement("insert into emp(name, dept, salary) values (?,?,?)");
            pstmt.setString(1,"Jack");
            pstmt.setString(2,"hr");
            pstmt.setDouble(3,30000);
            //executeQuery: rs vs executeUpdate: alwasy give me no of tuple effectd
            int val=pstmt.executeUpdate();
            System.out.println("conn is done: "+val);
        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("ex");
                }
            }
        }

    }
}
