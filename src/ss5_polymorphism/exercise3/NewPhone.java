package ss5_polymorphism.exercise3;

import ss5_polymorphism.exercise3.validation.PhoneValidation;

import java.util.Scanner;

public class NewPhone extends Phone {
    private int quantity;

    public NewPhone() {
    }

    public NewPhone(String id, String name, double price, int warranty, String manufacturer, int quantity) {
        super(id, name, price, warranty, manufacturer);
        this.quantity = quantity;
    }
    @Override
    public void input(){
        super.input();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter quantity: ");
//        this.quantity = scanner.nextInt();
        this.quantity = PhoneValidation.inputQuantity("Quantity");
    }
    @Override
    public void output(){
        super.output();
        System.out.println("Quantity: " + this.quantity);
    }
    @Override
    public String toString(){
        return super.toString() + String.format(",,, %s" , quantity);
    }
    @Override
    public  double calculateTotalPrice(){
        return  getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
