public class TV extends Electronic {

    private int screenSize;

    public TV(double price, int stock,
              String manufacturer, String brand,
              int maxVoltage, int maxPower,
              int screenSize) {

        super(price, stock, manufacturer, brand, maxVoltage, maxPower);
        this.screenSize = screenSize;
    }

    @Override
    public String getInfo() {
        return "TV{id=" + id +
                ", brand=" + brand +
                ", price=" + price +
                ", screenSize=" + screenSize + "}";
    }
}
