package PHONGBAN_JDBC;

import HomePage.FunctionHP;
import HomePage.ListIdTemp;
import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayEmpbyDep {
    public void Display() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter ID Department you want to show list Empoyees : ");
            int idShow = FunctionHP.getNumberScanner();

            List<Integer> idList = new ArrayList<>();
            idList= ListIdTemp.listIdDep();

            while (!idList.contains(idShow)) {
                System.out.println("this Id_Department don't have in the List Department.");
                System.out.println(" Enter again ID Department :");
                idShow = FunctionHP.getNumberScanner();
            }

            System.out.println("List Employees by department (ID Department = "+idShow+") :");

            String sql = "Select * from employee e JOIN department de ON e.Dep_ID = de.IdDep\n" +
                    "WHERE  de.IdDep = " + idShow + ";";

            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("___________________________________________________________________________________________________________________________" +
                    "_____________________________________________________________________" +
                    "____________________________________________________________________________________________________");

            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                    "EmployeeId", "Employee Name", "Email ", "Position ","Salary ","Tax", "Phone ","Is Manager ","Type Contract ","Join Date ","Level ","Country ","Department Name");
            System.out.println("___________________________________________________________________________________________________________________________" +
                    "_____________________________________________________________________" +
                    "____________________________________________________________________________________________________|");

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
                    int TruongPhong = resultSet.getInt("IsManager");
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
                    String NameDep = resultSet.getString("NameDep");

                    System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                            MaNV, TenNV, Email,position, dcf.format(Luong),dcf.format(tax), Sdt,
                            TruongPhongN,LoaiHD,NgayBatDau,TrinhDo,QuocTich,NameDep);
                }
                System.out.println("___________________________________________________________________________________________________________________________" +
                        "_____________________________________________________________________" +
                        "____________________________________________________________________________________________________|");

                System.out.println("The total number of records of Employee table: " + count);
            }
        } catch (Exception ex) {
            System.out.println("Error: Khong co this ID_Department! ");
        }
    }
}
