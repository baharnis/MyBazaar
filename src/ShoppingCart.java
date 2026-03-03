import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) { if (item != null) items.add(item); }

    public void clear() { items.clear(); }

    public List<Item> getItems() { return items; }

    public double getTotalPrice() {
        double total = 0;
        for (Item item : items) total += item.getPrice();
        return total;
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public int getItemCount() { return items.size(); }

    public double calculateTotal(List<Campaign> campaigns, double discountRate) {
        double total = 0;
        for (Item item : items) {
            double itemPrice = item.getPrice();
            for (Campaign c : campaigns) {
                if (c.getItemType().equalsIgnoreCase(item.getCategory())) {
                    itemPrice = itemPrice * (1 - c.getDiscountRate() / 100.0);
                }
            }
            itemPrice = itemPrice * (1 - discountRate / 100.0);
            total += itemPrice;
        }
        return total;
    }

    public void addItem(Item i) {
    }

    public void empty() {
    }
}
