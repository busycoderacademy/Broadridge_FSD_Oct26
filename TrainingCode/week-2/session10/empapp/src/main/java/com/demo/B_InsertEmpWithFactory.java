package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class B_InsertEmpWithFactory {
    public static void main(String[] args) {


        //get a connection object
        Connection connection=null;
        try{
             connection=ConnectionFactory.getConnection();

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
