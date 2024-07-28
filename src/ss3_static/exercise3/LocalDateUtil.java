package ss3_static.exercise3;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class LocalDateUtil {
    private static DateTimeFormatter formater_dMy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter formatter_yyyyMMdd = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static LocalDate fromStringDMY(String date){
        return LocalDate.parse(date, formater_dMy);
    }
    public static LocalDate fromStringyyyyMMdd(String date){
        return LocalDate.parse(date, formatter_yyyyMMdd);
    }
    public static String toString_ddMMyy(LocalDate date){
        return date.format(formater_dMy);
    }
    public static String toString_yyyyMMdd(LocalDate date){
        return date.format(formatter_yyyyMMdd);
    }
}
