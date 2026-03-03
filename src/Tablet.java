public class Tablet extends Computer {

    private String dimensions;

    public Tablet(double price, int stock,
                  String manufacturer, String brand,
                  int maxVoltage, int maxPower,
                  String operatingSystem, String cpuType,
                  int ramCapacity, int hddCapacity,
                  String dimensions) {

        super(price, stock, manufacturer, brand, maxVoltage, maxPower,
                operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.dimensions = dimensions;
    }

    @Override
    public String getInfo() {
        return "Tablet{id=" + id +
                ", brand=" + brand +
                ", price=" + price +
                ", stock=" + stock +
                ", dimensions=" + dimensions + "}";
    }
}

