package ss1_oop_overview.exercise3;

import java.util.Scanner;

public class Distance {
    int x;
    int y;
    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        x = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter y: ");
        y = Integer.parseInt(scanner.nextLine());

    }
    double distance(Distance otherDistance){
        return (Math.sqrt(Math.pow(otherDistance.x - x, 2))) + (Math.sqrt(Math.pow(otherDistance.y - y, 2)));
    }
}
