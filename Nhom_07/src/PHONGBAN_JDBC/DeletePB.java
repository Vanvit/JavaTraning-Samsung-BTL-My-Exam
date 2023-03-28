package PHONGBAN_JDBC;

import HomePage.FunctionHP;
import HomePage.ListIdTemp;
import Jdbc.JdbcConnect;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeletePB {

    public void deleteDataPB() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            Statement a = JdbcConnect.connectDB();

            System.out.println("Enter ID Department you want to delete: ");
            int key = FunctionHP.getNumberScanner();

            List<Integer> idList = new ArrayList<>();
            idList= ListIdTemp.listIdDep();

            while (!idList.contains(key)) {
                System.out.println("this Id_Department don't have in this List Department.");
                System.out.println(" Enter again ID Department :");
                key = FunctionHP.getNumberScanner();
            }

            String sql = "DELETE from DEPARTMENT WHERE IdDep= "+key;
            a.executeUpdate(sql);

            System.out.println("Department has (Id = "+ key+" ) deleted successful!");
        } catch (Exception ex) {
            System.out.println("Error: This record cannot be deleted because there are employees in this department!");
        }
    }
}
