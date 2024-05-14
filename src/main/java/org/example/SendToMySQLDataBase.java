package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SendToMySQLDataBase {

    final static String URL = "jdbc:mysql://localhost:3306/java_data";
    final static String USERNAME = "root";
    final static String PASSWORD = "TestPassword";

    public static void createTable(String name) {

        String SQL = "CREATE TABLE sort_data." + name + " (parameter1 VARCHAR(100));";

        Connection connection;
        PreparedStatement statement;
        try {
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        statement = connection.prepareStatement(SQL);
        statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fillTable(String name, String[] array){

        String SQL = "INSERT INTO sort_data." + name + "(parameter1) VALUES (?);";
        Connection connection;
        PreparedStatement statement;

        for (int i = 0; i < array.length;i++){
            try{
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                statement = connection.prepareStatement(SQL);
                statement.setString(1,array[i]);
                statement.executeUpdate();

            } catch (SQLException e) {
            throw new RuntimeException(e);
            }

        }

    }


}
