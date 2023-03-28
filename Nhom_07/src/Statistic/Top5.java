package Statistic;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Top5 {
    public void statisticMaxTop5Salary(){
        Scanner scanner = new Scanner(System.in);
        try {
            Statement statement = JdbcConnect.connectDB();

            String sql = " SELECT * FROM employee e Left JOIN department de ON e.Dep_ID = de.IdDep\n" +
                    " ORDER BY e.Salary DESC LIMIT 5;";

            ResultSet resultSet = statement.executeQuery(sql);


            System.out.println("Statistics of the top 5 highest paid employees: ");
            System.out.println("___________________________________________________________________________________________________________________________" +
                    "_____________________________________________________________________" +
                    "____________________________________________________________________________________________________");

            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                    "EmployeeId", "Employee Name", "Email ", "Position ","Salary ","Tax", "Phone ","Is Manager ","Type Contract ","Join Date ","Level ","Country ","Department Name");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------------------------|");


            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                int count = 0;
                while (resultSet.next()) {
                    count++;
                    int MaNV = resultSet.getInt("IdEmp");
                    String TenNV = resultSet.getString("NameEmp");
                    String Email = resultSet.getString("Email");
                    String position = resultSet.getString("Position");

                    double Luong = resultSet.getDouble("Salary");
                    double tax = resultSet.getDouble("Tax");

                    DecimalFormat dcf = new DecimalFormat("###,###,###,###.###");


                    String Sdt = resultSet.getString("Phone");
                    Integer TruongPhong = resultSet.getInt("IsManager");
                    String TruongPhongN;
                    if (TruongPhong == 1 ) {
                        TruongPhongN = "Manager";
                    }
                    else {
                        TruongPhongN = "Not Manager";
                    }


                    String LoaiHD = resultSet.getString("TypeContract");
                    String NgayBatDau = resultSet.getString("JoinDate");
                    String TrinhDo = resultSet.getString("Level");
                    String QuocTich = resultSet.getString("Country");
//                    int PB_ID = resultSet.getInt("Dep_ID");
                    String NameDep = resultSet.getString("NameDep");

                    System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                            MaNV, TenNV, Email,position, dcf.format(Luong),dcf.format(tax), Sdt,
                            TruongPhongN,LoaiHD,NgayBatDau,TrinhDo,QuocTich,NameDep);
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------" +
                        "---------------------------------------------------------------------" +
                        "-----------------------------------------------------------------------------------------------------");

                System.out.println("The total number of records of Employee table: " + count);
            }
        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }

    public void statisticMinTop5Salary(){
        Scanner scanner = new Scanner(System.in);
        try {
            Statement statement = JdbcConnect.connectDB();

            String sql = " SELECT e.*, de.NameDep FROM employee e JOIN department de ON e.Dep_ID = de.IdDep\n" +
                    " ORDER BY e.Salary ASC LIMIT 5;";

            ResultSet resultSet2 = statement.executeQuery(sql);


            System.out.println("Statistics of the top 5 lowest paid employees: ");

            System.out.println("___________________________________________________________________________________________________________________________" +
                    "_____________________________________________________________________" +
                    "____________________________________________________________________________________________________");

            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                    "EmployeeId", "Employee Name", "Email ", "Position ","Salary ","Tax", "Phone ","Is Manager ","Type Contract ","Join Date ","Level ","Country ","Department Name");

            System.out.println("--------------------------------------------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------" +
                    "-----------------------------------------------------------------------------------------------------|");


            if (!resultSet2.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                int count2 = 0;
                while (resultSet2.next()) {
                    count2++;
                    int MaNV = resultSet2.getInt("IdEmp");
                    String TenNV = resultSet2.getString("NameEmp");
                    String Email = resultSet2.getString("Email");
                    String position = resultSet2.getString("Position");

                    double Luong = resultSet2.getDouble("Salary");
                    double tax = resultSet2.getDouble("Tax");

                    DecimalFormat dcf = new DecimalFormat("###,###,###,###.###");


                    String Sdt = resultSet2.getString("Phone");
                    Integer TruongPhong = resultSet2.getInt("IsManager");
                    String TruongPhongN;
                    if (TruongPhong == 1 ) {
                        TruongPhongN = "Manager";
                    }
                    else {
                        TruongPhongN = "Not Manager";
                    }
                    String LoaiHD = resultSet2.getString("TypeContract");
                    String NgayBatDau = resultSet2.getString("JoinDate");
                    String TrinhDo = resultSet2.getString("Level");
                    String QuocTich = resultSet2.getString("Country");
//                    int PB_ID = resultSet.getInt("Dep_ID");
                    String NameDep = resultSet2.getString("NameDep");

                    System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                            MaNV, TenNV, Email,position, dcf.format(Luong),dcf.format(tax), Sdt,
                            TruongPhongN,LoaiHD,NgayBatDau,TrinhDo,QuocTich,NameDep);
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------" +
                        "---------------------------------------------------------------------" +
                        "-----------------------------------------------------------------------------------------------------");
                System.out.println("The total number of records of Employee table: " + count2);

            }
    } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
