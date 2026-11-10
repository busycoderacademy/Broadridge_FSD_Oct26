package com.bankapp.controller;
import java.sql.*;
public class HelloWorld {
    public static void main(String[] args) {



        try{
            Connection connection=ConnectionFactory.getConnection();

            Statement stmt=connection.createStatement();

            ResultSet rs=stmt.executeQuery("select * from emp");
//            ResultSetMetaData metaData=rs.getMetaData();
//            int columCount=metaData.getColumnCount();
//            for(int i=1;i<=columCount;i++){
//                System.out.println(metaData.getColumnName(i)+" : "+metaData.getColumnTypeName(i));
//            }
            //iterate and print all the tuples
            while (rs.next()) {
                System.out.println(rs.getInt("id")+": "+ rs.getString("name")+
                        ": "+rs.getString("dept")+": "+rs.getDouble(4));
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
