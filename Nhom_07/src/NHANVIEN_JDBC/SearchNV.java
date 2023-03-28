package NHANVIEN_JDBC;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SearchNV {
    public void searchDataNV() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter ID Employment/Name Employment/Phone Employment/ Email Employment you want to search :");
            String key = scanner.nextLine();

            String sql = "Select e.*, de.NameDep from employee e JOIN department de ON e.Dep_ID = de.IdDep WHERE e.NameEmp  LIKE '%" + key + "%'" +
                    "OR e.IdEmp  LIKE '%" + key + "%' OR e.Phone  LIKE '%" + key + "%' OR e.Email LIKE '%" + key + "%'";

            ResultSet resultSet = statement.executeQuery(sql);


            System.out.println("List Employees after Searching: ");
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
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
