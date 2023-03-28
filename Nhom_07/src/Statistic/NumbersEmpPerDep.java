package Statistic;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.Statement;

public class NumbersEmpPerDep {
    public void NumbersEmp(){
        try {
            Statement statement = JdbcConnect.connectDB();

            String sql = " SELECT COUNT(e.IdEmp) , de.NameDep FROM employee e left JOIN department de ON e.Dep_ID = de.IdDep\n" +
                    "GROUP BY NameDep;";

            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Statistics of the number of employees per the deparment: ");
            System.out.println("_________________________________________________________________________________________");
            System.out.printf("%-35s | %-50s | \n",
                    "Name Department ","Number of Employees");
            System.out.println("_________________________________________________________________________________________|");

            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                while (resultSet.next()) {
                    int number = resultSet.getInt("COUNT(e.IdEmp)");
                    String nameDep = resultSet.getString("NameDep");

                    System.out.printf("%-35s | %-50s | \n",
                            nameDep, number);
                }
                System.out.println("_________________________________________________________________________________________|");

            }
        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
