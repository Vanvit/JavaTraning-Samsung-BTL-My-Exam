package PHONGBAN_JDBC;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;

public class ViewPB {

    public ResultSet getDataPB() {

        try {
            ResultSet resultSet = JdbcConnect.connectDepartment();

            System.out.println("List Department: ");
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
            return resultSet;

        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
            return null;
        }
    }
}
