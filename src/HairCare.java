public class HairCare extends Cosmetic {
    private boolean isMedicated;

    public HairCare(String name, double price, int stock,
                    String manufacturer, String brand, String expirationDate,
                    double weight, boolean isOrganic, boolean isMedicated) {
        super(name, "HairCare", price, stock, manufacturer, brand, expirationDate, weight, isOrganic);
        this.isMedicated = isMedicated;
    }

    @Override
    public String getInfo() {
        return "HairCare{id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", expirationDate='" + getExpirationDate() + '\'' +
                ", weight=" + getWeight() +
                ", isOrganic=" + isOrganic() +
                ", isMedicated=" + isMedicated + "}";
    }
}
