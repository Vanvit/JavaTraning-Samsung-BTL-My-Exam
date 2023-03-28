package PHONGBAN_JDBC;

import HomePage.FunctionHP;
import Jdbc.JdbcConnect;

import java.sql.*;
import java.util.Scanner;

public class AddPB {
    public void insertDataPB() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        try {

            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter Name Department: ");
            String TenPB = scanner.nextLine();
            String TenPBNew = FunctionHP.getStrScanner(TenPB);

            System.out.println("Enter phone  for the Department : ");
            String SdtPB = scanner.nextLine();
            String SdtPBNew = FunctionHP.getStrScanner(SdtPB);

            String sql = "INSERT INTO DEPARTMENT(NameDep ,PhoneDep ) VALUES ('" + TenPBNew + "','" + SdtPBNew + "' )";
            statement.executeUpdate(sql);
            System.out.println("Add department:"+ TenPBNew + " into the table successfully.");

        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }

}
