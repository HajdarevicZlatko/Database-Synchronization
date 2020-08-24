package com.example.demo.DAL.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDriver {
    public static Connection getDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return  DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nosql", "root", "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
