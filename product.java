import java.util.*;

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}

public class SalesAnalyzer {
    public static void main(String[] args) {
        List<Product> sales = new ArrayList<>();
        sales.add(new Product("Product1", 45.99));
        sales.add(new Product("Product2", 75.50));
        sales.add(new Product("Product3", 110.75));
        sales.add(new Product("Product4", 25.25));
        sales.add(new Product("Product5", 150.0));
        
        Map<String, Integer> countByRange = new HashMap<>();
        Map<String, Double> revenueByRange = new HashMap<>();
        
        for (Product product : sales) {
            double price = product.getPrice();
            String range = getPriceRange(price);
            
            countByRange.put(range, countByRange.getOrDefault(range, 0) + 1);
            revenueByRange.put(range, revenueByRange.getOrDefault(range, 0.0) + price);
        }
        
        for (Map.Entry<String, Integer> entry : countByRange.entrySet()) {
            String range = entry.getKey();
            int count = entry.getValue();
            double revenue = revenueByRange.get(range);
            
            System.out.println("Range: " + range + ", Count: " + count + ", Revenue: $" + revenue);
        }
    }
    
    private static String getPriceRange(double price) {
        if (price >= 0 && price < 50) {
            return "$0-50";
        } else if (price >= 50 && price < 100) {
            return "$50-100";
        } else if (price >= 100 && price < 200) {
            return "$100-200";
        } else {
            return "Over $200";
        }
    }
}
