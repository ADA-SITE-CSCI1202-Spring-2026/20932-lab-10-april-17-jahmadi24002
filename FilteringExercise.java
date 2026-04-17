import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Product {
    String name;
    double price;
    boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return String.format("%s ($%.2f) - %s", name, price, inStock ? "In Stock" : "Out of Stock");
    }
}

public class FilteringExercise {
    public static void main(String[] args) {

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Mechanical Keyboard", 120.00, true));
        catalog.add(new Product("Wireless Mouse", 45.00, true));
        catalog.add(new Product("USB-C Cable", 15.00, false));
        catalog.add(new Product("Mousepad", 12.50, true));
        catalog.add(new Product("Webcam", 85.00, true));

        Predicate<Product> isAffordable = p -> p.price < 50 && p.inStock;

        
        catalog.removeIf(isAffordable.negate());

        System.out.println("Affordable and In-Stock Items:");
        catalog.forEach(System.out::println);
    }
}