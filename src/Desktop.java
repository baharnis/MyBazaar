public class Desktop extends Computer {

    private String boxColor;

    public Desktop(double price, int stock,
                   String manufacturer, String brand,
                   int maxVoltage, int maxPower,
                   String operatingSystem, String cpuType,
                   int ramCapacity, int hddCapacity,
                   String boxColor) {

        super(price, stock, manufacturer, brand, maxVoltage, maxPower,
                operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.boxColor = boxColor;
    }

    @Override
    public String getInfo() {
        return "Desktop{id=" + id +
                ", brand=" + brand +
                ", price=" + price +
                ", stock=" + stock +
                ", boxColor=" + boxColor + "}";
    }
}
