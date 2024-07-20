package ss1_oop_overview.exercise1;
import java.util.Scanner;
public class Student {
    String name;
    double mathScore;
    double literatureScore;

    void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter math score: ");
        mathScore = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter literature score: ");
        literatureScore = Double.parseDouble(scanner.nextLine());

    }
     double averageScore(){
        return (mathScore + literatureScore)/2 ;
    }
    void output(){
        System.out.println("Name: " + name);
        System.out.println("Math score is: " + mathScore);
        System.out.println("Literature score is: " + literatureScore);
        System.out.println("Average score is: " + averageScore());
    }
}
