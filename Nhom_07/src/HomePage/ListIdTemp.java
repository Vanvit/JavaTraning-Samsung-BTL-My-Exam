package HomePage;

import Jdbc.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListIdTemp {
    public static  List<Integer> listIDEmp (){

        List<Integer> idEmployeeIsNull = new ArrayList<>();
        try {

            ResultSet resultSet = JdbcConnect.connectEmployee();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                while (resultSet.next()) {
                    int MaNV = resultSet.getInt("IdEmp");
                    idEmployeeIsNull.add(MaNV);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return idEmployeeIsNull;
    }

    public static List<String> listEmailEmp (){
        List<String> idEmployeeEmail = new ArrayList<>();
        try {

            ResultSet resultSet = JdbcConnect.connectEmployee();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                while (resultSet.next()) {
                    String email = resultSet.getString("Email");
                    idEmployeeEmail.add(email);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return idEmployeeEmail;
    }

    public static  List<Integer> listIdDep (){

        List<Integer> idEmployeeIsNull = new ArrayList<>();
        idEmployeeIsNull.add(0);
        try {

            ResultSet resultSet = JdbcConnect.connectDepartment();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("---- No data ----");
            } else {
                while (resultSet.next()) {
                    int MaPB = resultSet.getInt("IdDep");
                    idEmployeeIsNull.add(MaPB);
                    String TenPB = resultSet.getString("NameDep");
                    String SdtPB = resultSet.getString("PhoneDep");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return idEmployeeIsNull;
    }




}
