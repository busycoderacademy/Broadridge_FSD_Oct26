package com.bankapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FundTransferApp {
    public static void main(String[] args) {
        Connection connection=ConnectionFactory.getConnection();
        try {
            //There is a concept in jdbc ie called auto commit =True
            connection.setAutoCommit(false); //till i am not saying commit dont permantly write to the db
            PreparedStatement pstmt=connection.prepareStatement("update account set balance=balance-? where id=?");
            pstmt.setDouble(1,10);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();

            PreparedStatement pstmt2=connection.prepareStatement("updae account set balance=balance+? where id=?");
            pstmt2.setDouble(1,10);
            pstmt2.setInt(2,2);
            pstmt2.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            System.out.println(e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
