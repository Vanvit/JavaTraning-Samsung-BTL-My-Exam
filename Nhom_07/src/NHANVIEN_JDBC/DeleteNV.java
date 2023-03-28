package NHANVIEN_JDBC;

import HomePage.FunctionHP;
import HomePage.ListIdTemp;
import Jdbc.JdbcConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteNV {
    public void deleteDataNV() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter ID Employee you want to delete: ");
            int key = FunctionHP.getNumberScanner();

            List<Integer> idList = new ArrayList<>();
            idList= ListIdTemp.listIDEmp();

            while (!idList.contains(key)) {
                System.out.println("this Id_Employee don't have in the List Employee.");
                System.out.println(" Enter again ID Employee :");
                key = FunctionHP.getNumberScanner();
            }
            String sql =  "DELETE from EMPLOYEE WHERE IdEmp = "+key+";";

            statement.executeUpdate(sql);
            System.out.println("Employee has (Id = "+ key+" ) deleted successful! ");

        } catch (Exception ex) {
            System.out.println("there are no records matching the search data!");
        }
    }
}
