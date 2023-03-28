package PHONGBAN_JDBC;

import HomePage.FunctionHP;
import HomePage.ListIdTemp;
import Jdbc.JdbcConnect;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdatePB {
    public void updateDataPB() throws ClassNotFoundException, SQLException {
        try {

            Scanner scanner = new Scanner(System.in);

            Statement statement = JdbcConnect.connectDB();

            System.out.println("Enter ID Department you want to edit: ");
            int MaPB = FunctionHP.getNumberScanner();

            List<Integer> idList = new ArrayList<>();
            idList= ListIdTemp.listIdDep();

            while (!idList.contains(MaPB)) {
                System.out.println("this Id_Department don't have in the List Department.");
                System.out.println(" Enter again ID Department :");
                MaPB = FunctionHP.getNumberScanner();
            }

            System.out.println("Enter the department name you want to update to:");
            String TenPB = scanner.nextLine();
            String TenPBN = FunctionHP.getStrScanner(TenPB);

            System.out.println("Enter the department phone you want to update to: ");
            String SdtPB = scanner.nextLine();
            String SdtPBN = FunctionHP.getStrScanner(SdtPB);

            String sql =  "UPDATE DEPARTMENT SET NameDep  = '"+TenPBN+"', PhoneDep  = '"
                    +SdtPBN+"'WHERE IdDep  =" +MaPB;

            statement.executeUpdate(sql);
            System.out.println("Updated department: "+TenPBN+" into the table successfully!");

        } catch (Exception ex) {
            System.out.println("Error: Fail");
            ex.printStackTrace();
        }
    }
}
