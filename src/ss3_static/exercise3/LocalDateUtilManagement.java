package ss3_static.exercise3;

import java.time.LocalDate;

public class LocalDateUtilManagement {
    public static void main(String[] args) {
        String dateString1 = "14/10/2023";
        String dateString2 = "2023/3/1";

        LocalDate localDate1 = LocalDateUtil.fromStringDMY(dateString1);
        LocalDate localDate2 = LocalDateUtil.fromStringyyyyMMdd(dateString2);

        System.out.println("LocalDate from LocalDate dd/MM/yyyy: " + localDate1);
        System.out.println("LocalDate from LocalDate yyyy/MM/dd: " + localDate2);

        LocalDate currentDate = LocalDate.now();

        String formatterDate1 = LocalDateUtil.toString_ddMMyy(currentDate);
        String formatterDate2 = LocalDateUtil.toString_yyyyMMdd(currentDate);
        System.out.println("String from LocalDate dd/MM/yyyy: " + formatterDate1);
        System.out.println("String from LocalDate yyyy/MM/dd: " + formatterDate2);
    }
}
