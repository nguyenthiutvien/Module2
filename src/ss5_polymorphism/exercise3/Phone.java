package ss5_polymorphism.exercise3;

import ss5_polymorphism.exercise3.validation.PhoneValidation;

import java.util.Scanner;

public abstract class Phone implements  Comparable<Phone>{
    private String id;
    private  String name;
    private double price;
    private int warranty;
    private String manufacturer;

    public Phone() {
    }

    public Phone(String id, String name, double price, int warranty, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
        this.manufacturer = manufacturer;
    }
    public  void input(){
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter name phone: ");
//        this.name = scanner.nextLine();
//
//        System.out.print("Enter price: ");
//        this.price = Double.parseDouble(scanner.nextLine());
//        System.out.print("Enter warranty: ");
//        this.warranty = Integer.parseInt(scanner.nextLine());
//        System.out.print("Enter manufacter: ");
//        this.manufacturer = scanner.nextLine();

         this.name = PhoneValidation.inputName("Name");
        this.price = PhoneValidation.inputPrice("Price");
        this.warranty = PhoneValidation.inputWarranty("Warranty");
        this.manufacturer = PhoneValidation.inputManufacturer("Manufacturer");

    }
    public void output(){
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
        System.out.println("Warranty: "+ this.warranty);
        System.out.println("Manufacturer: " + this.manufacturer);
    }

    public abstract double calculateTotalPrice();


    @Override
    public int compareTo(Phone phone){
        return Double.compare(this.getPrice(), phone.price);
    }
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s, %s", id, name, price, warranty, manufacturer);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
