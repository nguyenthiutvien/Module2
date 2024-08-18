package final_module;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceManager {
    private List<Customer> customers = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private List<String> errorMessages = new ArrayList<>();
    private int currentLine = 0;

    public void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                currentLine++;
                String[] data = line.split(", ");
                Customer customer = parseCustomer(data);
                if (customer != null) {
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeErrorsToFile("src/final_module/errors.txt");
    }

    private Customer parseCustomer(String[] data) {
        try {
            String name = data[0];
            LocalDate dateOfBirth = LocalDate.parse(data[1], formatter);
            String address = data[2];
            String idNumber = data[3];
            Insurance insurancePackage = parseInsurancePackage(data);
            if (insurancePackage != null) {
                return new Customer(name, dateOfBirth, address, idNumber, insurancePackage);
            } else {
                errorMessages.add("Dòng " + currentLine + ": Sai quy định về gói bảo hiểm");
            }
        } catch (Exception e) {
            if (e instanceof java.time.format.DateTimeParseException) {
                errorMessages.add("Dòng " + currentLine + ": Sai quy định ngày sinh");
            } else {
                errorMessages.add("Dòng " + currentLine + ": Sai định dạng dữ liệu");
            }
        }
        return null;
    }

    private Insurance parseInsurancePackage(String[] data) {
        try {
            String packageName = data[4];
            String term = data[5];
            long fee = Long.parseLong(data[6]);
            if (fee < 0) {
                errorMessages.add("Dòng " + currentLine + ": Sai quy định mức phí");
                return null;
            }
            String purpose = data[7];
            String paymentMethod = data[8];
            LocalDate startDate = LocalDate.parse(data[9], formatter);

            switch (packageName) {
                case "T":
                    String caseType = data[10];
                    String minParticipationTime = data[11];
                    return new DeathInsurance("BH tử vong", term, fee, purpose, paymentMethod, startDate, caseType, minParticipationTime);
                case "H":
                    LocalDate endDateH = LocalDate.parse(data[10], formatter);
                    String additionalProduct = data[11];
                    return new TermInsurance("BH theo thời hạn", term, fee, purpose, paymentMethod, startDate, endDateH, additionalProduct);
                case "S":
                    LocalDate endDateS = LocalDate.parse(data[10], formatter);
                    String allowancePeriod = data[11];
                    return new EndowmentInsurance("BH sinh kỳ", term, fee, purpose, paymentMethod, startDate, endDateS, allowancePeriod);
                default:
                    errorMessages.add("Dòng " + currentLine + ": Gói bảo hiểm không hợp lệ");
                    return null;
            }
        } catch (Exception e) {
            errorMessages.add("Dòng " + currentLine + ": Sai định dạng dữ liệu trong gói bảo hiểm");
            return null;
        }
    }

    private void writeErrorsToFile(String filePath) {
        if (errorMessages.isEmpty()) {
            return;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String errorMessage : errorMessages) {
                bufferedWriter.write(errorMessage);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số chứng minh thư: ");
        String id = scanner.nextLine();

        for (Customer customer : customers) {
            if (customer.getIdNumber().equals(id)) {
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Không tìm thấy thông tin khách hàng.");
    }

    public void displayHighestFeeInsurance() {
        long maxFee = 0;
        for (Customer customer : customers) {
            long fee = customer.getInsurancePackage().getFee();
            if (fee > maxFee) {
                maxFee = fee;
            }
        }

        for (Customer customer : customers) {
            if (customer.getInsurancePackage().getFee() == maxFee) {
                System.out.println(customer.getInsurancePackage());
            }
        }
    }

    public static void main(String[] args) {
        InsuranceManager manager = new InsuranceManager();
        manager.readFile("src/final_module/data.txt");
        manager.searchById();
        System.out.println("-----------------");
        manager.displayHighestFeeInsurance();
    }
}
