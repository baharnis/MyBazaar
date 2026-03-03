public class Laptop extends Computer {

    private boolean hdmiSupport;

    public Laptop(double price, int stock,
                  String manufacturer, String brand,
                  int maxVoltage, int maxPower,
                  String operatingSystem, String cpuType,
                  int ramCapacity, int hddCapacity,
                  boolean hdmiSupport) {

        super(price, stock, manufacturer, brand, maxVoltage, maxPower,
                operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.hdmiSupport = hdmiSupport;
    }

    @Override
    public String getInfo() {
        return "Laptop{id=" + id +
                ", brand=" + brand +
                ", price=" + price +
                ", stock=" + stock +
                ", hdmiSupport=" + hdmiSupport + "}";
    }
}
