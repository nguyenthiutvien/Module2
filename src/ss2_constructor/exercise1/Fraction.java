package ss2_constructor.exercise1;

import java.util.Scanner;

public class Fraction {
    int numerator;
    int denominator;

    public Fraction(){
        numerator = 0;
        denominator = 1;
    }
    public Fraction(int numerator){
        this.numerator = numerator;
        denominator = 1;
    }
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        compact();
    }

    void compact() {
        int ucln = UCLN(numerator, denominator);
        numerator = numerator / ucln;
        denominator = denominator / ucln;

    }

    int UCLN(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }
        a = Math.abs(a);
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
    public  void output(){
        if (denominator ==1){
            System.out.println(numerator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }
    public Fraction copy(){
        return  new Fraction(numerator, denominator);
    }
    public void sum(int a){
        numerator += a * denominator;
        compact();
    }

}

