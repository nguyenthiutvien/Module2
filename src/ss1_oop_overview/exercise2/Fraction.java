package ss1_oop_overview.exercise2;

import java.util.Scanner;

public class Fraction {
    int numerator;
    int denominator;
    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator is: ");
        numerator = Integer.parseInt(scanner.nextLine());

        do{
            System.out.print("Enter denominator is: ");
            denominator = Integer.parseInt(scanner.nextLine());
            if (denominator < 0){
                System.out.println("Denominator is not valid");
            }

        } while (denominator < 0);

    }
    void output(){
        compact();
        if ( denominator ==1){
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }
    void compact(){
        int ucln = UCLN(numerator, denominator);
        numerator= numerator/ucln;
        denominator = denominator / ucln;

    }
    int UCLN(int a, int b){
        if (a ==0 || b ==0){
            return 1;
        }
        a = Math.abs(a);
        for (int i = a; i >=1; i--){
            if (a % i ==0 && b%i ==0){
                return i;
            }
        }
        return 1;
    }
//     tong hai phan so
    Fraction sum(Fraction otherFraction){
        Fraction result = new Fraction();
        result.numerator = this.numerator * otherFraction.denominator + otherFraction.numerator * this.denominator;
        result.denominator = this.denominator * otherFraction.denominator;

        return  result;
    }
    Fraction multiplication(Fraction otherFraction){
        Fraction result = new Fraction();
        result.numerator = this.numerator *  otherFraction.numerator;
        result.denominator = this.denominator * otherFraction.denominator;

        return  result;
    }
    Fraction divide(Fraction otherFraction){
        Fraction result = new Fraction();
        result.numerator = this.numerator *  otherFraction.denominator;
        result.denominator = this.denominator * otherFraction.numerator;

        return  result;
    }
    boolean isPositiveFraction(){
        return  numerator * denominator > 0 || numerator ==0;
    }
    boolean is0Fraction(){
        return  numerator ==0;
    }

}
