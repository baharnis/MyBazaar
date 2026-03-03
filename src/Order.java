import java.util.List;

public class Order {

    private Customer customer;
    private double totalCost;
    private List<Item> items;

    public Order(Customer customer, double totalCost, List<Item> items) {
        this.customer = customer;
        this.totalCost = totalCost;
        this.items = items;
    }

    public Customer getCustomer() { return customer; }

    public double getTotalCost() { return totalCost; }

    public List<Item> getItems() { return items; }
}
