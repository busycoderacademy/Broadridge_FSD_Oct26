package com.demo;
//it can use to hide the complicity of connection creation and it can be singleton too

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.io.*;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory(){}

    public static Connection getConnection(){
        //i have to read the prop file from the resouces folder (ie from classpath)

        Properties properties=new Properties();//special hashtable to read the value from property file
        InputStream input = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("db.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e);
        }

        String driver=properties.getProperty("database.driver");
        String url=properties.getProperty("database.url");
        String username=properties.getProperty("database.username");
        String password=properties.getProperty("database.password");


        try{
            Class.forName(driver);
            System.out.println("driver is loaded");
        }catch (ClassNotFoundException e){
            System.out.println("driver is not loaded");
        }
       try {
           connection = connection = DriverManager
                   .getConnection(url,
                           username, password);
       }catch (SQLException e){
           e.printStackTrace();
       }
       return  connection;
    }
}
