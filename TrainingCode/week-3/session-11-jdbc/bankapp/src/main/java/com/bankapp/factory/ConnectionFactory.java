package com.bankapp.factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection;

    private  ConnectionFactory(){}

    public static Connection getConnection(){
        //1. how to featch the values from the property file, there is a class in java collection api,
        InputStream inputStream=ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("db.properties");

        Properties prop=new Properties();// to load the prop values from a file
        try {
            prop.load(inputStream);//it will seperate k and values from that file
        } catch (IOException e) {
            System.out.println(e);
        }
        String url=prop.getProperty("database.url");
        String driver=prop.getProperty("database.driver");
        String username=prop.getProperty("database.username");
        String password=prop.getProperty("database.password");
        try {
            Class.forName(driver);//Dynamic class loading*
            System.out.println("driver is loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("driver is not loaded");
        }
      try{
          connection= DriverManager.getConnection(url, username,password);
      }catch (SQLException ex){
          ex.printStackTrace();
      }
      return connection;
    }
}
