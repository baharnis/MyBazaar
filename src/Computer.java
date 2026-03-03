public abstract class Computer extends Electronic {

    protected String operatingSystem;
    protected String cpuType;
    protected int ramCapacity;
    protected int hddCapacity;

    public Computer(double price, int stock,
                    String manufacturer, String brand,
                    int maxVoltage, int maxPower,
                    String operatingSystem, String cpuType,
                    int ramCapacity, int hddCapacity) {

        super(price, stock, manufacturer, brand, maxVoltage, maxPower);
        this.operatingSystem = operatingSystem;
        this.cpuType = cpuType;
        this.ramCapacity = ramCapacity;
        this.hddCapacity = hddCapacity;
    }
}
