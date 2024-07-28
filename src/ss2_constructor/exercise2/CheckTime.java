package ss2_constructor.exercise2;

public class CheckTime {
    public static void main(String[] args) {
        Time time1 = new Time();
        time1.output();

        Time time2 = new Time(7);
        time2.output();

        Time time3 = new Time(7, 30);
        time3.output();

        Time time4 = new Time(7, 30, 50);
        time4.output();

        Time time5 = new Time(time4);
        time5.output();
    }
}
