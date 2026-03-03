import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyBazaar {

    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private List<Campaign> campaigns = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addUser(User u) { users.add(u); }
    public void addItem(Item i) { items.add(i); }

    public Customer findCustomer(int id) {
        for (User u : users) {
            if (u instanceof Customer && u.getId() == id)
                return (Customer) u;
        }
        return null;
    }

    public User findUserByName(String name) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name))
                return u;
        }
        return null;
    }

    public Item findItemById(int id) {
        for (Item i : items) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public void processCommand(String cmd) {
        String[] p = cmd.split("\t");
        String main = p[0].toUpperCase();

        switch (main) {
            case "ADDUSER":
            case "ADDCUSTOMER": handleAddUser(p); break;
            case "ADDITEM": handleAddItem(p); break;
            case "CREATECAMPAIGN": handleAddCampaign(p); break;
            case "ORDER": handleOrder(p); break;
            case "SHOWCUSTOMER": handleShowCustomer(p); break;
            case "SHOWCUSTOMERS": handleShowCustomers(p); break;
            case "SHOWADMININFO": handleShowAdminInfo(p); break;
            case "SHOWCAMPAIGNS": handleShowCampaigns(p); break;
            case "ADDTOCART": handleAddToCart(p); break;
            case "EMPTYCART": handleEmptyCart(p); break;
            case "DEPOSITMONEY": handleDepositMoney(p); break;
            case "CHPASS": handleChangePassword(p); break;
            case "SHOWORDERS": handleShowOrders(p); break;
            case "SHOWITEMSLOWONSTOCK": handleShowItemsLowOnStock(p); break;
            case "SHOWVIP": handleShowVIP(p); break;
            case "ADDADMIN": handleAddAdmin(p); break;
            case "ADDTECH": handleAddTech(p); break;
            case "LISTITEM": handleListItem(p); break;
            case "DISPITEMSOF": handleDispItemsOf(p); break;


            default: System.out.println("Invalid command: " + cmd);
        }
    }
    private void handleListItem(String[] p) {
        if (p.length < 2) return;
        String username = p[1];
        User u = findUserByName(username);
        if (u != null) {
            for (Item i : items) {
                System.out.println(i);
            }
        }
    }

    private void handleDispItemsOf(String[] p) {
        if (p.length < 3) return;
        String username = p[1];
        String[] types = p[2].split(":");
        User u = findUserByName(username);
        if (u != null) {
            for (Item i : items) {
                for (String t : types) {
                    if (i.getClass().getSimpleName().equalsIgnoreCase(t)) {
                        System.out.println(i);
                    }
                }
            }
        }
    }

    private void handleShowOrders(String[] p) {

    }

    private void handleShowItemsLowOnStock(String[] p) {

    }

    private void handleShowVIP(String[] p) {

    }

    private void handleAddAdmin(String[] p) {

    }

    private void handleAddTech(String[] p) {

    }

    private void handleAddUser(String[] p) {
        if (p.length < 6) return;
        String type = p[0].toUpperCase();
        try {
            if (type.equals("CUSTOMER") || type.equals("ADDCUSTOMER")) {
                Customer c = new Customer(p[1], p[2], p[3], Double.parseDouble(p[4]), p[5]);
                addUser(c);
            } else if (type.equals("ADMIN")) {
                Admin a = new Admin(p[1], p[2], p[3], Double.parseDouble(p[4]), p[5]);
                addUser(a);
            } else if (type.equals("TECH")) {
                Technician t = new Technician(p[1], p[2], p[3], Double.parseDouble(p[4]), p[5].equals("1"));
                addUser(t);
            }
        } catch (Exception e) { }
    }

    private void handleAddItem(String[] p) {
        if (p.length < 3) return;
        String type = p[0].toUpperCase();
        try {
            double price = Double.parseDouble(p[1]);
            int stock = Integer.parseInt(p[2]);
            if (type.equals("BOOK")) {
                Item book = new Book(price, stock, p[3], p[4]);
                addItem(book);
            }
            else if (type.equals("HAIRCARE")) {
                String name = p[3];
                double priceVal = price;
                int stockVal = stock;
                String manufacturer = p[4];
                String brand = p[5];
                String expirationDate = p[6];
                double weight = Double.parseDouble(p[7]);
                boolean isOrganic = p[8].equals("1");
                boolean isMedicated = p[9].equals("1");
                Item hair = new HairCare(name, priceVal, stockVal, manufacturer, brand, expirationDate, weight, isOrganic, isMedicated);
                addItem(hair);
            }
            else if (type.equals("SKINCARE")) {
                String name = p[3];
                double priceVal = price;
                int stockVal = stock;
                String manufacturer = p[4];
                String brand = p[5];
                String expirationDate = p[6];
                double weight = Double.parseDouble(p[7]);
                boolean isOrganic = p[8].equals("1");
                boolean isBabySensitive = p[9].equals("1");
                Item skin = new SkinCare(name, priceVal, stockVal, manufacturer, brand, expirationDate, weight, isOrganic, isBabySensitive);
                addItem(skin);
            }
            else if (type.equals("PERFUME")) {
                String name = p[3];
                double priceVal = price;
                int stockVal = stock;
                String manufacturer = p[4];
                String brand = p[5];
                String expirationDate = p[6];
                double weight = Double.parseDouble(p[7]);
                boolean isOrganic = p[8].equals("1");
                int lastingDuration = Integer.parseInt(p[9]);
                Item perf = new Perfume(name, priceVal, stockVal, manufacturer, brand, expirationDate, weight, isOrganic, lastingDuration);
                addItem(perf);
            }

        } catch (Exception e) { }
    }

    private void handleAddCampaign(String[] p) {
        if (p.length < 5) return;
        User admin = findUserByName(p[1]);
        if (!(admin instanceof Admin)) return;
        try {
            LocalDate start = LocalDate.parse(p[2], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate end = LocalDate.parse(p[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            String type = p[4].toUpperCase();
            double discount = Double.parseDouble(p[5]);
            Campaign camp = new Campaign(start, end, type, discount);
            campaigns.add(camp);
        } catch (Exception e) { }
    }

    private void handleOrder(String[] p) {
        if (p.length < 3) return;
        Customer c = findCustomer(Integer.parseInt(p[1]));
        if (c == null) return;
        List<Item> itemsToOrder = new ArrayList<>();
        for (int i = 2; i < p.length; i++) {
            Item it = findItemById(Integer.parseInt(p[i]));
            if (it != null) itemsToOrder.add(it);
        }
        if (!itemsToOrder.isEmpty()) {
            double totalCost = 0;
            for (Item it : itemsToOrder) totalCost += it.getPrice();
            orders.add(new Order(c, totalCost, itemsToOrder));
        }
    }


    private void handleShowCustomer(String[] p) {
        if (p.length < 2) return;
        User u = findUserByName(p[1]);
        if (u instanceof Customer) System.out.println(u);
    }

    private void handleShowCustomers(String[] p) {
        for (User u : users) {
            if (u instanceof Customer) System.out.println(u);
        }
    }

    private void handleShowAdminInfo(String[] p) {
        if (p.length < 2) return;
        User u = findUserByName(p[1]);
        if (u instanceof Admin) System.out.println(u);
    }

    private void handleShowCampaigns(String[] p) {
        for (Campaign c : campaigns) System.out.println(c);
    }

    private void handleAddToCart(String[] p) {
        if (p.length < 3) return;
        Customer c = findCustomer(Integer.parseInt(p[1]));
        Item i = findItemById(Integer.parseInt(p[2]));
        if (c != null && i != null) c.getCart().addItem(i);
    }

    private void handleEmptyCart(String[] p) {
        if (p.length < 2) return;
        Customer c = findCustomer(Integer.parseInt(p[1]));
        if (c != null) c.getCart().empty();
    }

    private void handleDepositMoney(String[] p) {
        if (p.length < 3) return;
        Customer c = findCustomer(Integer.parseInt(p[1]));
        if (c != null) c.depositMoney(Double.parseDouble(p[2]));
    }

    private void handleChangePassword(String[] p) {
        if (p.length < 4) return;
        Customer c = findCustomer(Integer.parseInt(p[1]));
        if (c != null) c.changePassword(p[2], p[3]);
    }
}
