package PHONGBAN_JDBC;

import HomePage.FunctionHP;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class FunctionDepartment {

    public int  departmentPage() {
        out.println("------ Human Resource Management -------");
        out.println("                                II. Department                                ");
        out.println("1. Show All Department");
        out.println("2. Insert Department");
        out.println("3. Update Department");
        out.println("4. Delete Department");
        out.println("5. Search Department");
        out.println("6. Display a list of employees by department");
        out.println("7. Add employees to the Department");
        out.println("8. Delete employees from the Department");
        out.println("9. Transfer of departments for employees");
        out.println("10. Sort Employees by Salary for the Department");

        out.println("11. Back to Home Page");
        out.println("----------------------------------------");

        out.print("Enter Option Number 1 - 11: ");
        int emp = FunctionHP.getNumberScanner();

        while (emp < 1 || emp > 11) {
            out.println("Must be input the option 1 - 11!");
            out.print("Enter again: ");
            emp = FunctionHP.getNumberScanner();
        }
        return emp;
    }
}
