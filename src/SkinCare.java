public class SkinCare extends Cosmetic {
    private boolean isBabySensitive;

    public SkinCare(String name, double price, int stock,
                    String manufacturer, String brand, String expirationDate,
                    double weight, boolean isOrganic, boolean isBabySensitive) {
        super(name, "SkinCare", price, stock, manufacturer, brand, expirationDate, weight, isOrganic);
        this.isBabySensitive = isBabySensitive;
    }

    @Override
    public String getInfo() {
        return "SkinCare{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", expirationDate='" + getExpirationDate() + '\'' +
                ", weight=" + getWeight() +
                ", isOrganic=" + isOrganic() +
                ", babySensitive=" + isBabySensitive + "}";
    }
}
