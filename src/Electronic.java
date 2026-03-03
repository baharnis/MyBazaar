public abstract class Electronic extends Item {

    protected String manufacturer;
    protected String brand;
    protected int maxVoltage;
    protected int maxPower;

    public Electronic(double price, int stock,
                      String manufacturer, String brand,
                      int maxVoltage, int maxPower) {

        super(price, stock);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.maxVoltage = maxVoltage;
        this.maxPower = maxPower;
    }

}
