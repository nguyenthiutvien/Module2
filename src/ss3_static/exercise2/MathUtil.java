package ss3_static.exercise2;
//Viết một lớp MathUtil chứa các phương thức tĩnh (static) để thực hiện các chức năng sau:
//
//Cộng 2 số.
//Trừ 2 số.
//Nhân 2 số.
//Chia 2 số.
public class MathUtil {
    public  static  double add(double a, double b){
        return  a + b;
    }
    public  static  double subtract(double a, double b){
        return  a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }
    public static double divide(double a, double b){
        return a / b;
    }
}
