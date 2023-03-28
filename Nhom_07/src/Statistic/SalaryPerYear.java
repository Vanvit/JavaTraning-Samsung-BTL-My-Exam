package Statistic;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class SalaryPerYear {
    public void caculateSalaryPerYear(){
        try {
            Statement statement = JdbcConnect.connectDB();

            String sql = "Select YEAR(JoinDate), sum(Salary) as 'AVG SALARY'\n" +
                    "From employee\n" +
                    "GROUP BY YEAR(JoinDate); ";

            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Statistic the Salary  per the Year: ");
            System.out.println("_________________________________________________________________________________________");
            System.out.printf("%-35s | %-50s | \n",
                    " Employee's starting year ","AVG SALARY");
            System.out.println("_________________________________________________________________________________________|");

            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                while (resultSet.next()) {
                    String nameDep = resultSet.getString("YEAR(JoinDate)");
                    DecimalFormat dcf = new DecimalFormat("###,###,###,###.###");
                    double max = resultSet.getDouble("AVG SALARY");

                    System.out.printf("%-35s | %-50s | \n",
                            nameDep, dcf.format(max));
                }
                System.out.println("_________________________________________________________________________________________|");

            }
        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
