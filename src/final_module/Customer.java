package final_module;

import java.time.LocalDate;

public class Customer {
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String idNumber;
    private Insurance insurancePackage;

    public Customer(String name, LocalDate dateOfBirth, String address, String idNumber, Insurance insurancePackage) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.idNumber = idNumber;
        this.insurancePackage = insurancePackage;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Insurance getInsurancePackage() {
        return insurancePackage;
    }

    @Override
    public String toString() {
        return "Ho ten: " + name + "\nNgay sinh: " + dateOfBirth + "\nNoi thuong tru: " + address +
                "\nSo chung minh thu: " + idNumber + "\n" + insurancePackage;
    }
}
