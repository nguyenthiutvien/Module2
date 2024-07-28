package ss2_constructor.exercise1;
//Tạo lớp PhanSo có các constructor và phương thức xuat() để đáp ứng yêu cầu đề bài.
public class CheckFraction {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        fraction.output();

        Fraction fraction1 = new Fraction(1 ,2);
        fraction1.output();

        Fraction fraction2 = new Fraction(3);
        fraction2.output();

        Fraction fraction3 = new Fraction(-12, -6);
        fraction3.output();

        Fraction fraction4 = fraction3.copy();
        fraction4.sum(20);
        fraction4.output();


    }
}
