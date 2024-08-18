package final_module;

import java.time.LocalDate;

public class DeathInsurance extends Insurance {
    private String caseType;
    private String minParticipationTime;

    public DeathInsurance(String packageName, String term, long fee, String purpose, String paymentMethod, LocalDate startDate,
                          String caseType, String minParticipationTime) {
        super(packageName, term, fee, purpose, paymentMethod, startDate);
        this.caseType = caseType;
        this.minParticipationTime = minParticipationTime;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLoai BH: " + caseType + "\nThoi gian toi thieu tham gia: " + minParticipationTime;
    }
    @Override
    public boolean isValid() {
        return fee > 1000000 && fee < 10000000000L;
    }

}
