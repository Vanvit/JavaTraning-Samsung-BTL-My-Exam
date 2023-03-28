package HomePage;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class FunctionHP {
    public void loginAdmin() {
        Scanner scanner = new Scanner(in);
        out.println("------ Human Resource Management -------");
        out.println("                Login                   ");

        out.print("Username: ");    // admin1
        String userName = scanner.nextLine();
        out.print("Password: ");    // 123456
        String password = scanner.nextLine();

        ResultSet resultSet = null;
        try {
            // check login admin
            resultSet = JdbcConnect.checkAdmin();

            if(resultSet.next()){
                while (!userName.equals(resultSet.getString("UserName")) ||
                        ! password.equals(resultSet.getString("Password"))) {

                    out.println("Need to enter the correct administrator account !");

                    out.println("------ Human Resource Management -------");
                    out.println("                                Login                                   ");
                    out.print("Username: ");
                    userName = scanner.nextLine();
                    out.print("Password: ");
                    password = scanner.nextLine();
                }
                out.println("Hello " + resultSet.getString("FullName"));
                out.println("Login successfully!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int homePage() {
        out.println("------ Human Resource Management -------");
        out.println("                                    Home Page                                ");

        Scanner scanner1 = new Scanner(in);

        out.println("1. Employee");
        out.println("2. Department");
        out.println("3. Statistics");
        out.println("4. Exit");
        out.println("----------------------------------------");
        out.print("Enter Option Number 1 - 4: ");
        int h = FunctionHP.getNumberScanner();

        while (h < 1 || h > 4) {
            out.println("Must be input the option 1 - 4!");
            out.print("Enter again: ");
            h = FunctionHP.getNumberScanner();
        }
        return h;
    }



    public static Integer getNumberScanner() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println(" You enter not a number! Please enter again! :  ");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
    public static String getStrScanner(String key) {
        Scanner scanner = new Scanner(System.in);
        while (key.trim().isEmpty()) {
            out.println("This field is required. Please enter again! :");
            key = scanner.nextLine();
        }
        return key.trim();
    }
    public static String getStrScanner2(String key) {
        Scanner scanner = new Scanner(System.in);
        while (key.length()==0) {
            out.println("This field is required. Please enter again! :");
            key = scanner.nextLine();
        }
        return key.trim();
    }
//    public static Date getDate() {
//        Scanner scanner = new Scanner(System.in);
//        Date date =null;
//        boolean check = false;
//        while (check == false) {
//            String dateData = scanner.nextLine();
//            try {
//                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                 date = (Date) formatter.parse(dateData);
//                 check = true;
//            } catch (ParseException e) {
//                System.out.println("Input data is not in the correct format. Plz try again with format yyyy-MM-dd : ");
//            }
//        }
//        return date;
//    }


}
