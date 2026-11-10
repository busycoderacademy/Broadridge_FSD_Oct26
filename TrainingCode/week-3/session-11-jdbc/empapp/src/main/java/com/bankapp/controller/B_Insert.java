package com.bankapp.controller;

import java.sql.*;

public class B_Insert {
    public static void main(String[] args) {



        try{
            Connection connection=ConnectionFactory.getConnection();
            PreparedStatement pstmt=
                    connection.
                            prepareStatement("insert into emp(name, dept, salary) values(?,?,?)",
                                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,"Bob");
            pstmt.setString(2, "Sales");
            pstmt.setDouble(3, 5500);
            pstmt.executeUpdate();//what was auto generated PK i want to show it to my client

            ResultSet rs=pstmt.getGeneratedKeys();
            if(rs.next()){
                System.out.println("hey customer ur reg no is this keep it safe : "+rs.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println(e);
        }






//        //1. load the driver help to connection to db
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");//Dynamic class loading*
//            System.out.println("driver is loaded");
//        } catch (ClassNotFoundException e) {
//            System.out.println("driver is not loaded");
//        }
//        Connection connection=null;
//        //2.Create the conn object me java ---------------- db ip port no username password
//        try {
//             connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/raj222",
//                    "root","root");
//            //featch : executeQuery or we want to insert/update/delate: executeUpdate
//            //Statement, PrepareStatement, CallableStatement
//            //Statement: is only for hello world should not used in real life, slow, sql injection*
//            //PrepareStatement: pre compiled query cache 2. no possiblity of SQL inject
//            //CallableStatement: PrepareStatement+ to call Store Procedure aka function that can be written mysql
//            Statement stmt=connection.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from emp");
//            //iterate and print all the tuples
//            while (rs.next()) {
//                System.out.println(rs.getInt("id")+": "+ rs.getString("name")+
//                        ": "+rs.getString("dept")+": "+rs.getDouble(4));
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }finally {
//            if(connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.out.println(e);
//                }
//            }
//        }
    }
}
