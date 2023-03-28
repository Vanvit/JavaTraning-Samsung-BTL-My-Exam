package Statistic;

import HomePage.FunctionHP;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class FunctionStatistic {

    public int  statisticPage() {
        out.println("------ Human Resource Management -------");
        out.println("                                III. Statistic                                ");
        out.println("1. Top 5 highest paid employees");
        out.println("2. Top 5 lowest paid employees");
        out.println("3. Statistics of the number of employees per the department");
        out.println("4. Statistics of departments with the highest average salary");
        out.println("5. Statistic the Salary  per the Year");
        out.println("6. Back to Home Page");
        out.println("----------------------------------------");
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
