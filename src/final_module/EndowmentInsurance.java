package final_module;

import java.time.LocalDate;

public class EndowmentInsurance extends Insurance {
    private LocalDate endDate;
    private String allowancePeriod;

    public EndowmentInsurance(String packageName, String term, long fee, String purpose, String paymentMethod, LocalDate startDate,
                              LocalDate endDate, String allowancePeriod) {
        super(packageName, term, fee, purpose, paymentMethod, startDate);
        this.endDate = endDate;
        this.allowancePeriod = allowancePeriod;
    }

    @Override
    public String toString() {
        return super.toString() + "\nThoi gian ket thuc: " + endDate + "\nThoi gian tro cap: " + allowancePeriod;
    }
    public boolean isValid() {
        return fee > 1000000 && fee < 10000000000L;
    }

}
