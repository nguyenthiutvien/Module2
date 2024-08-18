package ss12_regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringValidator {
    // Kiểm tra số điện thoại
    public static boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^(0|\\+84)(32|33|34|35|36|37|38|39)\\d{7}$";
        return Pattern.matches(phoneRegex, phone);
    }

    // Kiểm tra email
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9_]{6,32}@[A-Za-z0-9]{2,12}\\.[A-Za-z0-9]{2,12}$";
        return Pattern.matches(emailRegex, email);
    }

    // Kiểm tra username
    public static boolean isValidUsername(String username) {
        String usernameRegex = "^[A-Za-z0-9._]{6,32}$";
        return Pattern.matches(usernameRegex, username);
    }

    // Kiểm tra password
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^[A-Z](?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*.,])[A-Za-z0-9!@#$%^&*.,]{5,31}$";
        return Pattern.matches(passwordRegex, password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào một chuỗi: ");
        String input = scanner.nextLine();

        // Kiểm tra số điện thoại
        if (isValidPhoneNumber(input)) {
            System.out.println("Chuỗi là số điện thoại hợp lệ.");
        } else {
            System.out.println("Chuỗi không phải là số điện thoại hợp lệ.");
        }

        // Kiểm tra email
        if (isValidEmail(input)) {
            System.out.println("Chuỗi là email hợp lệ.");
        } else {
            System.out.println("Chuỗi không phải là email hợp lệ.");
        }

        // Kiểm tra username
        if (isValidUsername(input)) {
            System.out.println("Chuỗi là username hợp lệ.");
        } else {
            System.out.println("Chuỗi không phải là username hợp lệ.");
        }

        // Kiểm tra password
        if (isValidPassword(input)) {
            System.out.println("Chuỗi là password hợp lệ.");
        } else {
            System.out.println("Chuỗi không phải là password hợp lệ.");

        }

    }


}
