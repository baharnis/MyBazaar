public class Perfume extends Cosmetic {
    private int lastingDuration;

    public Perfume(String name, double price, int stock,
                   String manufacturer, String brand, String expirationDate,
                   double weight, boolean isOrganic, int lastingDuration) {
        super(name, "Perfume", price, stock, manufacturer, brand, expirationDate, weight, isOrganic);
        this.lastingDuration = lastingDuration;
    }

    @Override
    public String getInfo() {
        return "Perfume{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", expirationDate='" + getExpirationDate() + '\'' +
                ", weight=" + getWeight() +
                ", isOrganic=" + isOrganic() +
                ", lastingDuration=" + lastingDuration + "}";
    }
}
