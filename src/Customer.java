import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private static int nextId = 1;
    private int customerId;
    private String password;
    private double balance;
    private Status status;
    private ShoppingCart cart;
    private List<Order> orderHistory;

    public static final double SILVER_LIMIT = 1000.0;
    public static final double GOLDEN_LIMIT = 5000.0;
    public static final double SILVER_DISCOUNT = 0.10;
    public static final double GOLDEN_DISCOUNT = 0.15;

    public enum Status {CLASSIC, SILVER, GOLDEN}

    public Customer(String name, String email, String birthDate, double balance, String password) {
        super(name, email, birthDate);
        this.customerId = nextId++;
        this.balance = balance;
        this.password = password;
        this.status = Status.CLASSIC;
        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public int getCustomerId() { return customerId; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public double getBalance() { return balance; }

    public void depositMoney(double amount) {
        if (amount > 0) balance += amount;
    }

    public Status getStatus() { return status; }

    public ShoppingCart getCart() { return cart; }

    public List<Order> getOrderHistory() { return orderHistory; }

    public void updateStatus() {
        if (balance >= GOLDEN_LIMIT) status = Status.GOLDEN;
        else if (balance >= SILVER_LIMIT) status = Status.SILVER;
        else status = Status.CLASSIC;
    }

    public boolean verifyPassword(String pw) {
        return password.equals(pw);
    }

    public void addOrder(Order order) {
        if (order != null) orderHistory.add(order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", status=" + status +
                '}';
    }
    public void changePassword(String oldPass, String newPass) {
        if (this.password.equals(oldPass)) {
            this.password = newPass;
        } else {
            System.out.println("Old password is incorrect");
        }
    }


}
