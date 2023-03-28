package Statistic;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

public class HighestAvgSalaryPerDep {
    public void caculateHighestAvgSalaryPerDep(){
        try {
            Statement statement = JdbcConnect.connectDB();

            String sql = "SELECT b.NameDep, AVG(Salary) AS MAX_AVG_SALARY\n" +
                    "FROM employee a left JOIN department b ON b.IdDep = Dep_ID\n" +
                    "GROUP BY b.NameDep\n" +
                    "ORDER BY AVG(Salary) DESC LIMIT 1; ";

            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Statistics of department with the highest average salary: ");
            System.out.println("_________________________________________________________________________________________");
            System.out.printf("%-35s | %-50s | \n",
                    "Name Department ","MAX_AVG_SALARY");
            System.out.println("_________________________________________________________________________________________|");

            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                while (resultSet.next()) {
                    String nameDep = resultSet.getString("NameDep");
                    DecimalFormat dcf = new DecimalFormat("###,###,###,###.###");
                    double max = resultSet.getDouble("MAX_AVG_SALARY");

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
