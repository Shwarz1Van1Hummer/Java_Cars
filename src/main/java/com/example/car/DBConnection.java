package com.example.car;
import java.sql.*;

public class DBConnection {

    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/genus", "postgres", "Alma");
        System.out.println("its ok");
    }

}
