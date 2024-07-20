package ss1_oop_overview.exercise2;

public class CheckFraction {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        System.out.println("Enter fraction 1");
        fraction1.input();
        System.out.println("Enter fraction 2: ");
        fraction2.input();

        Fraction sum = fraction1.sum(fraction2);
        System.out.print("Sum is: ");
        sum.output();
        Fraction mutiple = fraction1.multiplication(fraction2);
        System.out.print("Multiplication is: ");
        mutiple.output();

        Fraction divide = fraction1.divide(fraction2);
        System.out.print("Divide is: " );
        divide.output();
        System.out.println("Fraction 1 is " + (fraction1.isPositiveFraction() ? "positive": "negative"));
        System.out.println("Fraction 2 is " + (fraction2.isPositiveFraction() ? "positive": "negative"));


        System.out.println("Fraction 1 is " + (fraction1.is0Fraction() ? "0": "not 0"));
        System.out.println("Fraction 2 is " + (fraction2.is0Fraction() ? "0": "not 0"));

    }


}
