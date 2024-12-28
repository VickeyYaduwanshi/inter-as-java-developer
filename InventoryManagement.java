import java.io.*;
import java.util.*;

class Product implements Serializable {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}

public class InventoryManagement {
    private static final String FILE_NAME = "inventory.dat";
    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = loadInventory();
    }

    private HashMap<Integer, Product> loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (HashMap<Integer, Product>) ois.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    private void saveInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    public void addProduct(int id, String name, double price, int quantity) {
        if (inventory.containsKey(id)) {
            System.out.println("Product with ID " + id + " already exists.");
        } else {
            inventory.put(id, new Product(id, name, price, quantity));
            saveInventory();
            System.out.println("Product added successfully.");
        }
    }

    public void updateProduct(int id, double price, int quantity) {
        Product product = inventory.get(id);
        if (product != null) {
            product.setPrice(price);
            product.setQuantity(quantity);
            saveInventory();
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            saveInventory();
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void searchProduct(int id) {
        Product product = inventory.get(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void generateReport() {
        double totalValue = 0;
        System.out.println("\nInventory Report:");
        for (Product product : inventory.values()) {
            System.out.println(product);
            totalValue += product.getPrice() * product.getQuantity();
            if (product.getQuantity() < 5) {
                System.out.println("Low stock warning for product: " + product.getName());
            }
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. Search Product\n5. Generate Report\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    im.addProduct(id, name, price, quantity);
                }
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter New Quantity: ");
                    int quantity = sc.nextInt();
                    im.updateProduct(id, price, quantity);
                }
                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    im.deleteProduct(id);
                }
                case 4 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    im.searchProduct(id);
                }
                case 5 -> im.generateReport();
                case 6 -> {
                    sc.close();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
