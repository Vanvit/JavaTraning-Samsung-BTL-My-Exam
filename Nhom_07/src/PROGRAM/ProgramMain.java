package PROGRAM;

import HomePage.FunctionHP;
import NHANVIEN_JDBC.*;
import PHONGBAN_JDBC.*;
import Statistic.*;

import java.sql.SQLException;

public class ProgramMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //login
        FunctionHP functionHP = new FunctionHP();
        functionHP.loginAdmin();
        // Home Page
        while (true) {
            int h = functionHP.homePage();
            // Employee
            if (h == 1) {
                while (true) {
                    FunctionEmployee functionEmployee = new FunctionEmployee();
                    // Employee page
                    int emp = functionEmployee.employeePage();
                    // Employee option
                    if (emp == 1) {
                        ViewNV viewNV = new ViewNV();
                        viewNV.getDataNV();
                    } else if (emp == 2) {
                        ViewNV viewNV2 = new ViewNV();
                        viewNV2.getDataNV();

                        AddNV addNV = new AddNV();
                        addNV.insertData();

                        System.out.println("List Employee after inserting: ");
                        ViewNV viewNV = new ViewNV();
                        viewNV.getDataNV();
                    } else if (emp == 3) {
                        ViewNV viewNV3 = new ViewNV();
                        viewNV3.getDataNV();

                        UpdateNV updateNV = new UpdateNV();
                        updateNV.updateDataNV();

                        System.out.println("List Employee after updating: ");
                        ViewNV viewNV = new ViewNV();
                        viewNV.getDataNV();
                    } else if (emp == 4) {
                        ViewNV viewNV4 = new ViewNV();
                        viewNV4.getDataNV();

                        DeleteNV deleteNV = new DeleteNV();
                        deleteNV.deleteDataNV();

                        System.out.println("List Employee after deleting: ");
                        ViewNV viewNV = new ViewNV();
                        viewNV.getDataNV();
                    } else if (emp == 5) {
                        ViewNV viewNV5 = new ViewNV();
                        viewNV5.getDataNV();

                        SearchNV searchNV = new SearchNV();
                        searchNV.searchDataNV();

                    } else {
                        System.out.println("Back to Home Page!");
                        break;
                    }
                }
            } else if (h == 2) {
                while (true) {
                    FunctionDepartment functionDepartment = new FunctionDepartment();
                    // Department page
                    int dep = functionDepartment.departmentPage();
                    // Department option
                    if (dep == 1) {
                        ViewPB viewPB = new ViewPB();
                        viewPB.getDataPB();
                    } else if (dep == 2) {
                        ViewPB viewPB2 = new ViewPB();
                        viewPB2.getDataPB();

                        AddPB addPB = new AddPB();
                        addPB.insertDataPB();

                        System.out.println("List Employee after inserting: ");
                        ViewPB viewPB = new ViewPB();
                        viewPB.getDataPB();

                    } else if (dep == 3) {
                        ViewPB viewPB3 = new ViewPB();
                        viewPB3.getDataPB();

                        UpdatePB updatePB = new UpdatePB();
                        updatePB.updateDataPB();

                        System.out.println("List Employee after updating: ");
                        ViewPB viewPB = new ViewPB();
                        viewPB.getDataPB();
                    } else if (dep == 4) {
                        ViewPB viewPB4 = new ViewPB();
                        viewPB4.getDataPB();

                        DeletePB deletePB = new DeletePB();
                        deletePB.deleteDataPB();

                        ViewPB viewPB = new ViewPB();
                        viewPB.getDataPB();
                    } else if (dep == 5) {
                        ViewPB viewPB5 = new ViewPB();
                        viewPB5.getDataPB();

                        SearchPB searchPB = new SearchPB();
                        searchPB.searchDataPB();

                    } else if (dep == 6) {
                        ViewPB viewPB10 = new ViewPB();
                        viewPB10.getDataPB();

                        DisplayEmpbyDep displayEmpbyDep = new DisplayEmpbyDep();
                        displayEmpbyDep.Display();

                    } else if (dep == 7) {
                        AddEmptoDep addEmptoDep = new AddEmptoDep();
                        addEmptoDep.show();

                        ViewNV viewNV5 = new ViewNV();
                        viewNV5.getDataNV();

                    } else if (dep == 8) {
                        ViewPB viewPB5 = new ViewPB();
                        viewPB5.getDataPB();

                        DeleteEmpfromDep deleteEmpfromDep = new DeleteEmpfromDep();
                        deleteEmpfromDep.deleteDataNV();

                    } else if (dep == 9) {
                        ViewPB viewPB5 = new ViewPB();
                        viewPB5.getDataPB();

                        TransferOfDepforEm transferOfDepforEm = new TransferOfDepforEm();
                        transferOfDepforEm.transferDataNV();

                    } else if (dep == 10) {
                        ViewPB viewPB5 = new ViewPB();
                        viewPB5.getDataPB();

                        Sort sort = new Sort();
                        sort.sortEmployee();
                    }
                    else {
                        System.out.println("Back to Home Page!");
                        break;
                    }
                }
            } else if (h == 3) {
                while (true) {
                    FunctionStatistic functionStatistic = new FunctionStatistic();
                    // Employee page
                    int emp = functionStatistic.statisticPage();
                    // Employee option
                    if (emp == 1) {
                        ViewNV viewNV = new ViewNV();
                        viewNV.getDataNV();

                        Top5 top5 = new Top5();
                        top5.statisticMaxTop5Salary();

                    } else if (emp == 2) {
                        ViewNV viewNV2 = new ViewNV();
                        viewNV2.getDataNV();

                        Top5 top5 = new Top5();
                        top5.statisticMinTop5Salary();

                    } else if (emp == 3) {
                        ViewNV viewNV3 = new ViewNV();
                        viewNV3.getDataNV();

                        NumbersEmpPerDep numbersEmpPerDep = new NumbersEmpPerDep();
                        numbersEmpPerDep.NumbersEmp();

                    } else if (emp == 4) {
                        ViewNV viewNV3 = new ViewNV();
                        viewNV3.getDataNV();

                        HighestAvgSalaryPerDep highestAvgSalaryPerDep = new HighestAvgSalaryPerDep();
                        highestAvgSalaryPerDep.caculateHighestAvgSalaryPerDep();

                    }
                    else if (emp == 5) {
                        ViewNV viewNV3 = new ViewNV();
                        viewNV3.getDataNV();

                        SalaryPerYear salaryPerYear = new SalaryPerYear();
                        salaryPerYear.caculateSalaryPerYear();
                    }
                    else {
                        System.out.println("Back to Home Page!");
                        break;
                    }
                }

            } else {
                System.out.println("Exit Program!");
                break;
            }
        }
    }
}
