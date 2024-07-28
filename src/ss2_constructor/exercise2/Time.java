package ss2_constructor.exercise2;

public class Time {
    private int hours;
    private int minutes;
    private  int seconds;

    public Time (){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    public Time (int hours){
        this.hours = hours;
        minutes = 0;
        seconds = 0;
    }
    public Time (int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
        seconds = 0;
    }
    public Time (int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public Time ( Time otherTime){
        this.hours = otherTime.hours;
        this.minutes = otherTime.minutes;
        this.seconds = otherTime.seconds;
    }
    public void output(){
        System.out.printf("%d:%d:%d", hours, minutes, seconds);
        System.out.println();
    }
}
