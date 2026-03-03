public abstract class Item {
    protected int id;
    protected String name;
    protected String category;
    protected double price;
    protected int stock;

    private static int nextId = 1;

    public Item(String name, String category, double price, int stock) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Item(double price, int stock) {
    }

    public Item(int id, double price, int stock) {
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean isLowOnStock() {
        final int LOW_STOCK_LIMIT = 5;
        return stock < LOW_STOCK_LIMIT;
    }

    public void decreaseStock(int qty) {
        if (qty <= 0) return;
        stock -= qty;
        if (stock < 0) stock = 0;
    }

    @Override
    public String toString() {
        return "Item{id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public abstract String getInfo();
}
