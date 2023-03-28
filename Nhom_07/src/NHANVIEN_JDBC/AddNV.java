package NHANVIEN_JDBC;

import HomePage.ListIdTemp;
import PHONGBAN_JDBC.ViewPB;
import Statistic.AdFunctions;
import HomePage.FunctionHP;
import Jdbc.JdbcConnect;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNV {

    public void insertData() throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        try {
            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter Name Employee you want to add: ");
            String tenNV = scanner.nextLine();
            String tenNVNew = FunctionHP.getStrScanner(tenNV);

            System.out.println("Enter Email Employee you want to add: ");
            String email = scanner.nextLine();
            String emailN = FunctionHP.getStrScanner(email);

            List<String> emailList = new ArrayList<>();
            emailList = ListIdTemp.listEmailEmp();

            while (emailList.contains(emailN)) {
                System.out.println("This employee Email is existed on the Employee List.");
                System.out.println(" Enter again employee Email :");
                email = scanner.nextLine();
                emailN = FunctionHP.getStrScanner(email);
            }

            System.out.println("Enter Phone Employee you want to add: ");
            String phone = scanner.nextLine();
            String phoneN = FunctionHP.getStrScanner(phone);


            System.out.println("Enter Position (choose 1,2,3,4,5 or 6): ");
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

            System.out.println("Enter Salary for this Employee: ");
            double salary = FunctionHP.getNumberScanner();

            AdFunctions adFunctions = new AdFunctions();
            double taxf = adFunctions.CaculationTaxEmp(salary);

            System.out.printf("--> Employee's Tax:  %.1f\n", taxf);

            System.out.println();

//            System.out.println("Enter the employee's start date ('yyyy-MM-dd'): "); ???
            LocalDate ngayBD = LocalDate.now();

            ViewPB viewPB = new ViewPB();
            viewPB.getDataPB();

            System.out.println("Enter Id Department for this Employee (Enter 0 When Employee not yet the department): ");

            int pbid = FunctionHP.getNumberScanner();

            List<Integer> idList = new ArrayList<>();
            idList = ListIdTemp.listIdDep();

            while (!idList.contains(pbid)) {
                System.out.println("this Id_Department don't have in the List Department.");
                System.out.println(" Enter again ID Department :");
                pbid = FunctionHP.getNumberScanner();
            }

//            scanner.nextLine();
//            System.out.println("Is Manager (Choose 1 or 0 ): ");
//            System.out.println("1. Maneger");
//            System.out.println("0. Not Maneger");
//            int isManeger = scanner.nextInt();
//            while (true) {
//                if (isManeger == 0) {
//                    System.out.println("You have selected this person: Not Manager");
//                    break;
//                } else if (isManeger == 1) {
//                    System.out.println("You have selected this person: Manager");
//                    break;
//                } else {
//                    System.out.println("Please re-enter (choose 1 or 0): ");
//                    isManeger = scanner.nextInt();
//                }
//            }

//            String sql = "INSERT INTO EMPLOYEE(NameEmp,Email,Phone,Position,Salary,Tax, JoinDate,Dep_ID)" +
//                    " VALUES ('" + tenNVNew + "', '" + emailN + "', '" + phoneN + "','" + positionN + "','" + salary + "', '" + taxf + "','" + ngayBD + "'," + pbid + ");";

            String nhhh  = "NULL";
            String sql = "";
            if (pbid == 0) {
                sql = "INSERT INTO EMPLOYEE(NameEmp,Email,Phone,Position,Salary,Tax, JoinDate,Dep_ID)" +
                        " VALUES ('" + tenNVNew + "', '" + emailN + "', '" + phoneN + "','" + positionN + "','" + salary + "', '" + taxf + "','" + ngayBD + "'," + nhhh + ");";

            } else {
                sql = "INSERT INTO EMPLOYEE(NameEmp,Email,Phone,Position,Salary,Tax, JoinDate,Dep_ID)" +
                        " VALUES ('" + tenNVNew + "', '" + emailN + "', '" + phoneN + "','" + positionN + "','" + salary + "', '" + taxf + "','" + ngayBD + "'," + pbid + ");";

                System.out.println("Inserted Employee: " + tenNVNew + " into the table successfully");
            }
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
