public class SmartPhone extends Electronic {

    private String screenType;

    public SmartPhone(double price, int stock,
                      String manufacturer, String brand,
                      int maxVoltage, int maxPower,
                      String screenType) {

        super(price, stock, manufacturer, brand, maxVoltage, maxPower);
        this.screenType = screenType;
    }

    @Override
    public String getInfo() {
        return "SmartPhone{id=" + id +
                ", brand=" + brand +
                ", price=" + price +
                ", stock=" + stock +
                ", screenType=" + screenType + "}";
    }
}
