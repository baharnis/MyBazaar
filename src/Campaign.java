import java.time.LocalDate;

public class Campaign {

    private LocalDate startDate;
    private LocalDate endDate;
    private String itemType;
    private double discountRate;

    public static final double MAX_DISCOUNT = 50.0;

    public Campaign(LocalDate startDate, LocalDate endDate, String itemType, double discountRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.itemType = itemType;
        this.discountRate = Math.min(discountRate, MAX_DISCOUNT);
    }

    public LocalDate getStartDate() { return startDate; }

    public LocalDate getEndDate() { return endDate; }

    public String getItemType() { return itemType; }

    public double getDiscountRate() { return discountRate; }

    @Override
    public String toString() {
        return "Campaign{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", itemType='" + itemType + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }
}
