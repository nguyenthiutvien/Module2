package ss5_polymorphism.exercise3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManagement {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Phone> phones = new ArrayList<>();

    static {
        phones.add(new ss5_polymorphism.exercise3.OldPhone("DTC001", "Samsung S10", 179990.0, 3, "Samsung", 90, "Used"));
        phones.add(new ss5_polymorphism.exercise3.OldPhone("DTC001", "Samsung S12", 279990.0, 3, "Samsung", 90, "Used"));
        phones.add(new ss5_polymorphism.exercise3.NewPhone("DTM001", "Samsung S13", 119990.0, 3, "Samsung", 20));
        phones.add(new ss5_polymorphism.exercise3.NewPhone("DTM001", "Samsung S14", 129990.0, 3, "Samsung", 20));

    }

    public static void main(String[] args) {
        int choose;
        while (true) {
            do {
                System.out.println("----Chuong trinh quan ly dien thoai");
                System.out.println("1. Xem danh sach dien thoai");
                System.out.println("2. Add");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Arrange by price");
                System.out.println("6. Search");
                System.out.println("7. Bill");
                System.out.println("8. Discount for old phone");
                System.out.println("9. Exits");

                System.out.print("You will chose: ");
                choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        menu();
                        break;
                    case 2:
                        addNew();
                        break;
                    case 3:
                        update();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        sort();
                        break;
                    case 6:
                        search();
                        break;
                    case 7:
                        System.out.println("Total price: " + calculateBill());
                        break;
                    case 8:
                        System.out.print(" Enter percent discount: ");
                        double percent = Double.parseDouble(scanner.nextLine());
                        applyDiscount(percent);
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Your choice is not valid. Please try again!");

                }
            } while (choose < 1 || choose > 5);
        }
    }

    private static void menu() {
        int choosen;
        while (true) {
            do {
                System.out.println("List phone");
                System.out.println("1. View all phone");
                System.out.println("2. View new phone");
                System.out.println("3. View old phone");
                System.out.println("4. Comeback main menu");

                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());

                switch (choosen) {
                    case 1:
                        System.out.println("--------List all phone----------");
                        for (int i = 0; i < phones.size(); i++) {
                            System.out.println("Information of phone " + (i + 1));
                            phones.get(i).output();
                        }
                        break;
                    case 2:
                        System.out.println("--------List old phone----------");
                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof ss5_polymorphism.exercise3.OldPhone) {
                                System.out.println("Information of old phone " + (count++));
                                phone.output();
                            }

                        }
                        break;
                    case 3:
                        System.out.println("--------List new phone----------");
                        int counts = 1;
                        for (Phone phone : phones) {
                            if (phone instanceof ss5_polymorphism.exercise3.NewPhone) {
                                System.out.println("Information of old phone " + (counts++));
                                phone.output();
                            }

                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 0 || choosen > 4);
        }
    }

    public static void addNew() {
        int choosen;
        while (true) {
            do {
                System.out.println("Add phone");
                System.out.println("1. Add new phone");
                System.out.println("2. Add old phone");
                System.out.println("3. Comeback main menu");

                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());

                switch (choosen) {
                    case 1:
                        ss5_polymorphism.exercise3.NewPhone newPhone = new ss5_polymorphism.exercise3.NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone());
                        phones.add(newPhone);
                        break;
                    case 2:
                        ss5_polymorphism.exercise3.OldPhone oldPhone = new ss5_polymorphism.exercise3.OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone());
                        phones.add(oldPhone);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 1 || choosen > 3);
        }
    }

    public static String getIdOldPhone() {

        ArrayList<ss5_polymorphism.exercise3.OldPhone> oldPhones = getOldPhone();
        if (oldPhones.size() == 0) {
            return "DRC001";
        }
        int max = Integer.parseInt(oldPhones.get(0).getId().substring(3));
        for (int i = 1; i < oldPhones.size(); i++) {
            int id = Integer.parseInt(oldPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTC%3d", max + 1).replace(" ", "0");
    }

    private static ArrayList<ss5_polymorphism.exercise3.OldPhone> getOldPhone() {
        ArrayList<ss5_polymorphism.exercise3.OldPhone> oldPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof ss5_polymorphism.exercise3.OldPhone) {
                oldPhones.add((ss5_polymorphism.exercise3.OldPhone) phone);
            }
        }
        return oldPhones;
    }

    public static String getIdNewPhone() {

        ArrayList<ss5_polymorphism.exercise3.NewPhone> newPhones = getNewPhone();

        if (newPhones.size() == 0) {
            return "DRM001";
        }
        int max = Integer.parseInt(newPhones.get(0).getId().substring(3));
        for (int i = 1; i < newPhones.size(); i++) {
            int id = Integer.parseInt(newPhones.get(i).getId().substring(3));
            if (max < id) {
                max = id;
            }
        }
        return String.format("DTM%3d", max + 1).replace(" ", "0");
    }

    private static ArrayList<ss5_polymorphism.exercise3.NewPhone> getNewPhone() {
        ArrayList<ss5_polymorphism.exercise3.NewPhone> newPhones = new ArrayList<>();
        for (Phone phone : phones) {
            if (phone instanceof ss5_polymorphism.exercise3.NewPhone) {
                newPhones.add((ss5_polymorphism.exercise3.NewPhone) phone);

            }
        }
        return newPhones;
    }

    public static void update() {
        System.out.println("Enter code you want to update");
        String id = scanner.nextLine();

        if (id.startsWith("DTC")) {
            boolean isExist = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExist = true;
                    phone.output();
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Can not find this code");
            }
        } else if (id.startsWith("DTM")) {
            boolean isExist = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExist = true;
                    phone.output();
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Can not find this code");
            }
        } else {
            System.out.println("Code is not valid");
        }
    }

    private static void delete() {
        System.out.println("Enter code you want to delete");
        String id = scanner.nextLine();

        if ((id.startsWith("DTC")) || (id.startsWith("DTM"))) {
            boolean isExist = false;
            for (Phone phone : phones) {
                if (phone.getId().equals(id)) {
                    isExist = true;
                    System.out.printf("Are you sure to delete %s ?\n", id);
                    System.out.println("Enter Y to delete , N to cancel");
                    if ("Y".equalsIgnoreCase(scanner.nextLine())) {
                        phones.remove(phone);
                        System.out.println("Delete successfully");
                    } else {
                        System.out.println("Cancel deleting");
                    }
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Can not find this code");
            }
        } else {
            System.out.println("Code is not valid");
        }
    }

    public static void sort() {
        int choosen;
        while (true) {
            do {
                System.out.println("Sort phone");
                System.out.println("1. ACS");
                System.out.println("2. DES");
                System.out.println("3. Comeback main menu");


                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());

                switch (choosen) {
                    case 1:
                        for (int i = 0; i < phones.size() - 1; i++) {
                            for (int j = 1; j < phones.size(); j++) {
                                if (phones.get(i).getPrice() > phones.get(j).getPrice()) {
                                    Phone temp = phones.get(i);
                                    phones.set(i, phones.get(j));
                                    phones.set(j, temp);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < phones.size() - 1; i++) {
                            for (int j = 1; j < phones.size(); j++) {
                                if (phones.get(i).getPrice() < phones.get(j).getPrice()) {
                                    Phone temp = phones.get(i);
                                    phones.set(i, phones.get(j));
                                    phones.set(j, temp);
                                }
                            }
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 0 || choosen > 3);
        }
    }


    public static void search() {
        int choosen;
        while (true) {
            do {
                System.out.println("Search phone");
                System.out.println("1. Search all phone");
                System.out.println("2. Search old phone");
                System.out.println("3. Search new menu");
                System.out.println("4. Comeback main menu");


                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());

                switch (choosen) {
                    case 1:
                        searchAllPhone();
                        break;
                    case 2:
                        searchOldPhone();
                        break;
                    case 3:
                        searchNewPhone();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 0 || choosen > 4);
        }
    }

    private static void searchAllPhone() {
        int choosen;
        while (true) {
            do {
                System.out.println("Search phone");
                System.out.println("1. Search by price");
                System.out.println("2. Search by name");
                System.out.println("3. Search by manufacture");
                System.out.println("4. Comeback search menu");


                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());

                switch (choosen) {
                    case 1:
                        System.out.println("Enter price you want to search: ");
                        System.out.print("From: ");
                        int fromPrice = Integer.parseInt(scanner.nextLine());

                        System.out.print("To: ");
                        int toPrice = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : phones) {
                            if (phone.getPrice() >= fromPrice && phone.getPrice() <= toPrice) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter name you want to find: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter manufacture you want to find: ");
                        String manufacture = scanner.nextLine();
                        count = 1;
                        for (Phone phone : phones) {
                            if (phone.getManufacturer().contains(manufacture)) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 0 || choosen > 4);
        }
    }

    private static void searchNewPhone() {
        int choosen;
        while (true) {
            do {
                System.out.println("Search new phone");
                System.out.println("1. Search by price");
                System.out.println("2. Search by name");
                System.out.println("3. Search by manufacture");
                System.out.println("4. Comeback search menu");


                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());
                ArrayList<NewPhone> newPhones = getNewPhone();
                switch (choosen) {
                    case 1:
                        System.out.println("Enter price you want to search: ");
                        System.out.print("From: ");
                        int fromPrice = Integer.parseInt(scanner.nextLine());

                        System.out.print("To: ");
                        int toPrice = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getPrice() >= fromPrice && phone.getPrice() <= toPrice) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter name you want to find: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter manufacture you want to find: ");
                        String manufacture = scanner.nextLine();
                        count = 1;
                        for (Phone phone : newPhones) {
                            if (phone.getManufacturer().contains(manufacture)) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 1 || choosen > 4);
        }
    }

    private static void searchOldPhone() {
        int choosen;
        while (true) {
            do {
                System.out.println("Search phone");
                System.out.println("1. Search by price");
                System.out.println("2. Search by name");
                System.out.println("3. Search by manufacture");
                System.out.println("4. Comeback search menu");


                System.out.print("You will chose: ");
                choosen = Integer.parseInt(scanner.nextLine());

                ArrayList<OldPhone> oldPhones = getOldPhone();
                switch (choosen) {
                    case 1:
                        System.out.println("Enter price you want to search: ");
                        System.out.print("From: ");
                        int fromPrice = Integer.parseInt(scanner.nextLine());

                        System.out.print("To: ");
                        int toPrice = Integer.parseInt(scanner.nextLine());

                        int count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getPrice() >= fromPrice && phone.getPrice() <= toPrice) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter name you want to find: ");
                        String name = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getName().contains(name)) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter manufacture you want to find: ");
                        String manufacture = scanner.nextLine();
                        count = 1;
                        for (Phone phone : oldPhones) {
                            if (phone.getManufacturer().contains(manufacture)) {
                                System.out.println("Information of phone " + count++);
                                phone.output();
                            }
                        }
                        break;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 1 || choosen > 4);
        }
    }

    public static double calculateBill(){
        double total = 0;
        for ( Phone phone : phones){
            total += phone.calculateTotalPrice();
        }
        return  total;
    }
    public  static  void applyDiscount (double percent){
        for (Phone phone : phones) {
            if (phone instanceof  OldPhone ){
                ((OldPhone) phone).applyDiscount(percent);
            }
        }
    }
}
