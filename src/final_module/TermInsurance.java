package final_module;

import java.time.LocalDate;

public class TermInsurance extends Insurance {
    private LocalDate endDate;
    private String additionalProduct;

    public TermInsurance(String packageName, String term, long fee, String purpose, String paymentMethod, LocalDate startDate,
                         LocalDate endDate, String additionalProduct) {
        super(packageName, term, fee, purpose, paymentMethod, startDate);
        this.endDate = endDate;
        this.additionalProduct = additionalProduct;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThoi gian ket thuc: " + endDate + "\nSan pham di kem: " + additionalProduct;
    }
    @Override
    public boolean isValid() {
        return fee > 1000000 && fee < 10000000000L;
    }

}
