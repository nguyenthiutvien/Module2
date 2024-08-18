package final_module;

import java.time.LocalDate;

public abstract  class Insurance {
    protected String packageName;
    protected String term;
    protected long fee;
    protected String purpose;
    protected String paymentMethod;
    protected LocalDate startDate;

    public Insurance(String packageName, String term, long fee, String purpose, String paymentMethod, LocalDate startDate) {
        this.packageName = packageName;
        this.term = term;
        this.fee = fee;
        this.purpose = purpose;
        this.paymentMethod = paymentMethod;
        this.startDate = startDate;
    }

    public long getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Ten goi BH: " + packageName + "\nThoi han: " + term + "\nMuc phi: " + fee + "\nMuc dich: " + purpose +
                "\nCach thuc dong phi: " + paymentMethod + "\nThoi gian bat dau: " + startDate;
    }
    public abstract boolean isValid();

}
