package ss4_inheritance.exercise1;

import javax.swing.*;
import java.util.Scanner;

public class OldPhone extends Phone {
    private int battery;
    private String description;

    public OldPhone() {
    }

    public OldPhone(String id, String name, double price, int warranty, String manufacturer, int battery, String description) {
        super(id, name, price, warranty, manufacturer);
        this.battery = battery;
        this.description = description;
    }
    @Override
    public void input(){
        super.input();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter batterry (%): ");
        this.battery = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter description: ");
        this.description = scanner.nextLine();

    }
    @Override
    public  void  output(){
        super.output();
        System.out.println("Battery (%) " + this.battery);
        System.out.println("Description: " + this.description);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
