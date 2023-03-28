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

public class AddEmptoDep {
    public void show() throws ClassNotFoundException, SQLException {
        while (true) {
            List<Integer> idEmployeeIsNull = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            try {
                Statement statement = JdbcConnect.connectDB();

                String sql = " SELECT e.*, de.NameDep FROM employee e Left JOIN department de ON e.Dep_ID = de.IdDep" +
                        " WHERE Dep_ID IS NULL;";
                ResultSet resultSet = statement.executeQuery(sql);

                System.out.println("Employee has no department: ");





//                System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-10s %-10s ",
//                        "IdEmp", "NameEmp ", "Email ", "Salary ", "Tax", "Phone ", "IsManager ", "TypeContract ", "JoinDate ", "Level ", "Country ", "Dep_ID");
//                System.out.println();
//
//                if (!resultSet.isBeforeFirst()) {
//                    System.out.println("---- No data ----");
//                } else {
//                    int count = 0;
//                    while (resultSet.next()) {
//                        count++;
//                        int MaNV = resultSet.getInt("IdEmp");
//                        idEmployeeIsNull.add(MaNV);
//                        String TenNV = resultSet.getString("NameEmp");
//                        String Email = resultSet.getString("Email");
//
//                        double Luong = resultSet.getDouble("Salary");
//                        double tax = resultSet.getDouble("Tax");
//
//                        DecimalFormat dcf = new DecimalFormat("###,###,###,###.###");
//
//
//                        String Sdt = resultSet.getString("Phone");
//                        Integer TruongPhong = resultSet.getInt("IsManager");
//                        String LoaiHD = resultSet.getString("TypeContract");
//                        String NgayBatDau = resultSet.getString("JoinDate");
//                        String TrinhDo = resultSet.getString("Level");
//                        String QuocTich = resultSet.getString("Country");
//                        int PB_ID = resultSet.getInt("Dep_ID");
//
//                        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-10s %-10s \n",
//                                MaNV, TenNV, Email, dcf.format(Luong), dcf.format(tax), Sdt,
//                                TruongPhong, LoaiHD, NgayBatDau, TrinhDo, QuocTich, PB_ID);
//                    }
//                    System.out.println("The total number of records of Employee table: " + count);
//                }
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
                        idEmployeeIsNull.add(MaNV);
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




                if (idEmployeeIsNull.size() == 0) {
                    System.out.println("All Employees has had the department already!. Plz choose the other function. ");
                    break;
                }
                System.out.println(" Enter ID Employee you want to add Department :");
                int idEmp = FunctionHP.getNumberScanner();

                while (!idEmployeeIsNull.contains(idEmp)) {
                    System.out.println("this Id_Employee as had the department already!");
                    System.out.println(" Enter again ID Employee (has ID_Dep = 0) you want to add Department :");
                    idEmp = FunctionHP.getNumberScanner();
                }

                ViewPB viewPB10 = new ViewPB();
                viewPB10.getDataPB();

                System.out.println(" Enter ID Department you want to add for this Employee :");
                int idDep = FunctionHP.getNumberScanner();

                List<Integer> idList = new ArrayList<>();
                idList= ListIdTemp.listIdDep();

                while (!idList.contains(idDep)) {
                    System.out.println("this Id_Department don't have in the List Department.");
                    System.out.println(" Enter again ID Department :");
                    idDep = FunctionHP.getNumberScanner();
                }


                String sql2 = " UPDATE employee\n" +
                        "SET Dep_ID = " + idDep + "\n" +
                        "WHERE IdEmp = " + idEmp + ";";

                statement.executeUpdate(sql2);
                System.out.println(" Added  Employee (IdEmployee = "+idEmp+")  to Department (IdEmployee = "+idDep+") succsessfully! ");


                System.out.println(" List Employee after Adding  Employee (IdEmployee = "+idEmp+")  to Department (IdEmployee = "+idDep+") : " );
                break;

            } catch (Exception ex) {
                System.out.println("Error: Fail");
                ex.printStackTrace();
            }
        }
    }
}
