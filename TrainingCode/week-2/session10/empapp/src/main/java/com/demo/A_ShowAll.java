package com.demo;
import java.sql.*;
public class A_ShowAll {
    public static void main(String[] args) {

      //load the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver is loaded");
        }catch (ClassNotFoundException e){
            System.out.println("driver is not loaded");
        }
        //get a connection object
        try{
            Connection connection=DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bankappraj?useSSL=false","root","root");
            //read all the records from the database table
            //Statement vs PreparedStatement vs CallableStatement
            //Statement: simple Query , bad perforamce, SQL injection
            //PreparedStatement: faster and no problem of sql injection
            //CallableStatement: used to call store procedue
            Statement stmt=connection.createStatement();
            //executeQuery: rs vs executeUpdate: alwasy give me no of tuple effectd
            ResultSet resultSet = stmt.executeQuery("select * from emp");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+": "+resultSet.getString("name")
                        +": "+ resultSet.getDouble("SALARY"));
            }
            System.out.println("conn is done");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
