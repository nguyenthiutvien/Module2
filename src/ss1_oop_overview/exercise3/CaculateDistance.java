package ss1_oop_overview.exercise3;

public class CaculateDistance {
    public static void main(String[] args) {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();
        System.out.println("Enter first point ");
        distance1.input();
        System.out.println("Enter second point");
        distance2.input();

        System.out.println("Distance from first point to second point is: " + distance1.distance(distance2));
    }
}
