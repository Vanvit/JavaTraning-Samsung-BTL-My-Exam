package NHANVIEN_JDBC;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.text.DecimalFormat;
public class ViewNV {

    public ResultSet getDataNV() {
        try {
            ResultSet resultSet = JdbcConnect.connectEmployee();

            System.out.println("List Employees : ");
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
                    String NameDepN;
                    if (NameDep == null ) {
                        NameDepN = "NOT yet Department";
                    }
                    else {
                        NameDepN = NameDep;
                    }

                    System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s | %-35s | \n",
                            MaNV, TenNV, Email,position, dcf.format(Luong),dcf.format(tax), Sdt,
                            TruongPhongN,LoaiHD,NgayBatDau,TrinhDo,QuocTich,NameDepN);
                }


                System.out.println("___________________________________________________________________________________________________________________________" +
                        "_____________________________________________________________________" +
                        "____________________________________________________________________________________________________|");
                System.out.println("The total number of records of Employee table: " + count);
            }
            return resultSet;

        } catch (Exception ex) {
            System.out.println("Eror: Fail");
            ex.printStackTrace();
            return null;
        }
    }
}
