package Statistic;

public class AdFunctions {
    public double CaculationTaxEmp(double luong) {
//        DecimalFormat dcf = new DecimalFormat("###,###,###,###,###.###");
        double tax;
        //tinh tax
        if (luong > 9000000 && luong <= 14000000) {
            tax = (luong - 9000000) * 0.05;
        } else if (luong > 14000000 && luong <= 19000000) {
            tax = (luong - 14000000) * 0.1 + 0.25 * 1000000;
        } else if (luong > 19000000 && luong <= 27000000) {
            tax = (luong - 19000000) * 0.15 + 0.75 * 1000000;
        } else if (luong > 27000000 && luong <= 41000000) {
            tax = (luong - 27000000) * 0.2 + 1.95 * 1000000;
        } else if (luong > 41000000 && luong <= 61000000) {
            tax = (luong - 41000000) * 0.25 + 4.95 * 1000000;
        } else if (luong > 61000000 && luong <= 89000000) {
            tax = (luong - 61000000) * 0.3 + 9.75 * 1000000;
        } else if (luong > 89000000) {
            tax = (luong - 89000000) * 0.35 + 18.15 * 1000000;
        } else {
            tax = 0;
        }
        //format
//        String pattern = "###,###,###,###.###";
//        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//
//        String format = decimalFormat.format(tax);
//        return format;
//        System.out.printf("%.1f", tax);
        return  tax;
    }

    public enum positionEmployee {
        MANAGER, FRESHER, SELLER, OPERATOR,PROGRAMER,TESTER
    }

}
