package PHONGBAN_JDBC;

import HomePage.FunctionHP;
import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchPB {
    public void searchDataPB() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter Id Department/ Department Name/ Department Phone you want to seach : ");
            String key = scanner.nextLine();
            String keyN = FunctionHP.getStrScanner(key);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT where IdDep  Like '%"+keyN+"%' OR NameDep  LIKE '%"+keyN+"%' OR PhoneDep  LIKE '%"+keyN+"%';");

            System.out.println("List Department after Searching: ");


            System.out.println("_____________________________________________________________________________");
            System.out.printf("%-10s | %-40s | %-20s | \n",
                    "IdDep ", "NameDep ", "PhoneDep ");

            System.out.println("_____________________________________________________________________________|");
            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    int MaPB = resultSet.getInt("IdDep");
                    String TenPB = resultSet.getString("NameDep");
                    String SdtPB = resultSet.getString("PhoneDep");

                    System.out.printf("%-10s | %-40s | %-20s | \n",
                            MaPB, TenPB, SdtPB);
                }
                System.out.println("_____________________________________________________________________________|");
                System.out.println("The total number of records of DEPARTMENT table: " + count);
            }
        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
