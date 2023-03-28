package NHANVIEN_JDBC;

import HomePage.FunctionHP;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class FunctionEmployee {

    public int  employeePage() {
        out.println("------ Human Resource Management -------");
        out.println("                                I. Employee                                ");
        out.println("1. Show All Employee");
        out.println("2. Insert Employee");
        out.println("3. Update Employee");
        out.println("4. Delete Employee");
        out.println("5. Search Employee");
        out.println("6. Back to Home Page");
        out.println("----------------------------------------");
        Scanner scanner2 = new Scanner(in);
        out.print("Enter Option Number 1 - 6: ");

        int emp = FunctionHP.getNumberScanner();

        while (emp < 1 || emp > 6) {
            out.println("Must be input the option 1 - 6!");
            out.print("Enter again: ");
            emp = FunctionHP.getNumberScanner();
        }
        return emp;
    }
}
