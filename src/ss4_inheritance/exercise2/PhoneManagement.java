package ss4_inheritance.exercise2;

import ss4_inheritance.exercise1.NewPhone;
import ss4_inheritance.exercise1.OldPhone;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManagement {
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<OldPhone> oldPhones = new ArrayList<>();
    static ArrayList<NewPhone> newPhones = new ArrayList<>();

    static {
        oldPhones.add(new OldPhone("DTC001", "Samsung S10", 179990.0, 3, "Samsung", 90, "Used"));
        oldPhones.add(new OldPhone("DTC002", "Samsung S12", 179990.0, 3, "Samsung", 90, "Used"));
        newPhones.add(new NewPhone("DTM001", "Iphone 15 pro max", 2000000, 2, "Apple", 20));
        newPhones.add(new NewPhone("DTM002", "Iphone 12 pro max", 2000000, 2, "Apple", 20));

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
                        for (int i = 0; i < oldPhones.size(); i++) {
                            System.out.println("Information of phone " + (i + 1));
                            oldPhones.get(i).output();
                        }
                        for (int i = 0; i < newPhones.size(); i++) {
                            System.out.println("Information of phone " + (i + 1));
                            newPhones.get(i).output();
                        }
                        break;
                    case 2:
                        System.out.println("--------List old phone----------");
                        for (int i = 0; i < oldPhones.size(); i++) {
                            System.out.println("Information of old phone " + (i + 1));
                            oldPhones.get(i).output();
                        }
                        break;
                    case 3:
                        System.out.println("--------List new phone----------");
                        for (int i = 0; i < newPhones.size(); i++) {
                            System.out.println("Information of new phone " + (i + 1));
                            newPhones.get(i).output();
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
                        NewPhone newPhone = new NewPhone();
                        newPhone.input();
                        newPhone.setId(getIdNewPhone());
                        newPhones.add(newPhone);
                        break;
                    case 2:
                        OldPhone oldPhone = new OldPhone();
                        oldPhone.input();
                        oldPhone.setId(getIdOldPhone());
                        oldPhones.add(oldPhone);
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

    public static String getIdNewPhone() {
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

    public static void update() {
        System.out.println("Enter code you want to update");
        String id = scanner.nextLine();

        if (id.startsWith("DTC")) {
            boolean isExist = false;
            for (OldPhone oldPhone : oldPhones) {
                if (oldPhone.getId().equals(id)) {
                    isExist = true;
                    oldPhone.output();
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Can not find this code");
            }
        } else if (id.startsWith("DTM")) {
            boolean isExist = false;
            for (NewPhone newPhone : newPhones) {
                if (newPhone.getId().equals(id)) {
                    isExist = true;
                    newPhone.output();
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

        if (id.startsWith("DTC")) {
            boolean isExist = false;
            for (OldPhone oldPhone : oldPhones) {
                if (oldPhone.getId().equals(id)) {
                    isExist = true;
                    System.out.printf("Are you sure to delete %s ?\n", id);
                    System.out.println("Enter Y to delete , N to cancel");
                    if ("Y".equalsIgnoreCase(scanner.nextLine())) {
                        oldPhones.remove(oldPhone);
                        System.out.println("Delete successfully");
                    } else {
                        System.out.println("Cancel deleting");
                    }
                    oldPhone.output();
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Can not find this code");
            }
        } else if (id.startsWith("DTM")) {
            boolean isExist = false;
            for (NewPhone newPhone : newPhones) {
                if (newPhone.getId().equals(id)) {
                    isExist = true;
                    System.out.printf("Are you sure to delete %s ?\n", id);
                    System.out.println("Enter Y to delete , N to cancel");
                    if ("Y".equalsIgnoreCase(scanner.nextLine())) {
                        oldPhones.remove(newPhone);
                        System.out.println("Delete successfully");
                    } else {
                        System.out.println("Cancel deleting");
                    }
                    newPhone.output();
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
                        break;
                    case 2:
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
                        break;
                    case 2:
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 1 || choosen > 4);
        }
    }

    private static void searchNewPhone() {
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
                        break;
                    case 2:
                        break;
                    case 3:
                        return;
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

                switch (choosen) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Your chose is invalid, please try again!!!! ");
                }

            } while (choosen < 1 || choosen > 4);
        }
    }

}
