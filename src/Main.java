import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Main users.txt item.txt commands.txt");
            return;
        }

        String usersFile = args[0];
        String itemsFile = args[1];
        String commandsFile = args[2];

        MyBazaar bazaar = new MyBazaar();

        try {
            BufferedReader brUsers = new BufferedReader(new FileReader(usersFile));
            String line;
            while ((line = brUsers.readLine()) != null) {
                String[] parts = line.split("\t");
                String type = parts[0].toUpperCase();
                if (type.equals("ADMIN")) {
                    Admin admin = new Admin(parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5]);
                    bazaar.addUser(admin);
                } else if (type.equals("TECH")) {
                    Technician tech = new Technician(parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5].equals("1"));
                    bazaar.addUser(tech);
                } else if (type.equals("CUSTOMER")) {
                    Customer customer = new Customer(parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5]);
                    bazaar.addUser(customer);
                }
            }
            brUsers.close();

            BufferedReader brItems = new BufferedReader(new FileReader(itemsFile));
            while ((line = brItems.readLine()) != null) {
                String[] parts = line.split("\t");
                String type = parts[0].toUpperCase();

            }
            brItems.close();

            BufferedReader brCommands = new BufferedReader(new FileReader(commandsFile));
            while ((line = brCommands.readLine()) != null) {
                bazaar.processCommand(line);
            }
            brCommands.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String usersFile = "C:\\Users\\Sevimgul\\Desktop\\untitled1\\users.txt";
    String itemsFile = "C:\\Users\\Sevimgul\\Desktop\\untitled1\\items.txt";
    String commandsFile = "C:\\Users\\Sevimgul\\Desktop\\untitled1\\commands.txt";
}