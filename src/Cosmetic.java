public abstract class Cosmetic extends Item {
    private String manufacturer;
    private String brand;
    private String expirationDate;
    private double weight;
    private boolean isOrganic;

    public Cosmetic(String name, String category, double price, int stock,
                    String manufacturer, String brand, String expirationDate,
                    double weight, boolean isOrganic) {
        super(name, category, price, stock);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.expirationDate = expirationDate;
        this.weight = weight;
        this.isOrganic = isOrganic;
    }

    public String getManufacturer() { return manufacturer; }
    public String getBrand() { return brand; }
    public String getExpirationDate() { return expirationDate; }
    public double getWeight() { return weight; }
    public boolean isOrganic() { return isOrganic; }

    public abstract String getInfo();
}
