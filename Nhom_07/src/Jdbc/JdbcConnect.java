package Jdbc;

import java.sql.*;

public class JdbcConnect {
    public static String url ="jdbc:mysql://localhost:3306/HR_MANEGERMENT";
    public static String username = "root";
    public static String password = "root";

    public static Statement connectDB() throws ClassNotFoundException, SQLException {
        //create Driver to connect to my sql
        Class.forName("com.mysql.cj.jdbc.Driver");
        // create connection with db name = "samsung", username= "root", password = "root"
        Connection connection = DriverManager.getConnection(JdbcConnect.url,JdbcConnect.username, JdbcConnect.password );
        // create statement
        Statement statement = connection.createStatement();

        return statement;
    }
    public static ResultSet checkAdmin() throws ClassNotFoundException, SQLException {

        Statement a = JdbcConnect.connectDB();
        // get data from table 'admin'
        ResultSet resultSet = a.executeQuery("SELECT * FROM ADMIN");

        return resultSet;
    }
    public static ResultSet connectEmployee() throws ClassNotFoundException, SQLException {

        Statement a = JdbcConnect.connectDB();

        ResultSet resultSet = a.executeQuery("Select e.*, de.NameDep from employee e left JOIN department de ON e.Dep_ID = de.IdDep");

        return resultSet;
    }
    public static ResultSet connectDepartment() throws ClassNotFoundException, SQLException {

        Statement a = JdbcConnect.connectDB();

        ResultSet resultSet = a.executeQuery("SELECT * FROM DEPARTMENT");
        return resultSet;
    }
}
