package NHANVIEN_JDBC;

import PHONGBAN_JDBC.ViewPB;
import Statistic.AdFunctions;
import HomePage.FunctionHP;
import HomePage.ListIdTemp;
import Jdbc.JdbcConnect;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateNV {
    public void updateDataNV() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        try {

            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter ID Employee you want to update: ");
            int maNV = FunctionHP.getNumberScanner();

            List<Integer> idList = new ArrayList<>();
            idList= ListIdTemp.listIDEmp();

            while (!idList.contains(maNV)) {
                System.out.println("this Id_Employee don't have in the List Employee.");
                System.out.println(" Enter again ID Employee :");
                maNV = FunctionHP.getNumberScanner();
            }

            System.out.println("Enter the employee name you want to update to: ");
            String tenNV = scanner.nextLine();
            String tenNVNew = FunctionHP.getStrScanner(tenNV);

            System.out.println("Enter Email Employee you want to update to: ");
            String email = scanner.nextLine();
            String emailN = FunctionHP.getStrScanner(email);

            List<String> emailList = new ArrayList<>();
            emailList= ListIdTemp.listEmailEmp();

            while (emailList.contains(emailN)) {
                System.out.println("This employee Email is existed on the Employee List.");
                System.out.println(" Enter again employee Email :");
                email = scanner.nextLine();
                emailN = FunctionHP.getStrScanner(email);
            }

            System.out.println("Enter Phone Employee you want to update: ");
            String phone = scanner.nextLine();
            String phoneN = FunctionHP.getStrScanner(phone);


            System.out.println("Enter Position (choose 1,2,3,4,5 or 6) you want to update: ");
            System.out.println("1. MANAGER");
            System.out.println("2. FRESHER");
            System.out.println("3. SELLER");
            System.out.println("4. OPERATOR");
            System.out.println("5. PROGRAMER");
            System.out.println("6. TESTER");

            int position = scanner.nextInt();
            String positionN = "---";
            while (true) {
                if (position == 1) {
                    System.out.println("you have selected the position for the employee: MANAGER");
                    positionN = "MANAGER";
                    break;
                } else if (position == 2) {
                    System.out.println("you have selected the position for the employee: FRESHER");
                    positionN = "FRESHER";
                    break;
                } else if (position == 3) {
                    System.out.println("you have selected the position for the employee: SELLER");
                    positionN = "SELLER";
                    break;
                } else if (position == 4) {
                    System.out.println("you have selected the position for the employee: OPERATOR");
                    positionN = "OPERATOR";
                    break;
                } else if (position == 5) {
                    System.out.println("you have selected the position for the employee: PROGRAMER");
                    positionN = "PROGRAMER";
                    break;
                } else if (position == 6) {
                    System.out.println("you have selected the position for the employee: TESTER");
                    positionN = "TESTER";
                    break;
                } else {
                    System.out.println("Please re-enter Position (choose 1,2,3,4,5 or 6): ");
                    position = scanner.nextInt();
                }
            }


            System.out.println("Enter Salary for this Employee you want to update: ");
            double salary = FunctionHP.getNumberScanner();

            AdFunctions cTax = new AdFunctions();
            double taxf = cTax.CaculationTaxEmp(salary);

            System.out.printf("--> Employee's Tax:  %.1f\n", taxf);

//            System.out.println("Enter the employee's start date ('yyyy-MM-dd'): ");
//            String ngayBD = scanner.nextLine();
//            LocalDate ngayBD = LocalDate.now();

            ViewPB viewPB = new ViewPB();
            viewPB.getDataPB();
            System.out.println("Enter Id Department: ");
            int pbid = FunctionHP.getNumberScanner();
            List<Integer> idList2 = new ArrayList<>();
            idList2= ListIdTemp.listIdDep();

            while (!idList2.contains(pbid)) {
                System.out.println("this Id_Department don't have in the List Department.");
                System.out.println(" Enter again ID Department :");
                pbid = FunctionHP.getNumberScanner();
            }

            String sql =  "UPDATE employee\n" +
            "SET NameEmp = '"+tenNVNew+"', Email = '"+emailN+"', Phone ='"+phoneN+"'" +
                    ",POSITION = '"+positionN+"',Salary = '"+salary+"',Salary = '"+taxf+"',Dep_ID = '"+pbid+"'"+
            "WHERE IdEmp = "+maNV+";";

            statement.executeUpdate(sql);
            System.out.println("Updated Employee: "+tenNVNew+" into the table successfully!");

        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
