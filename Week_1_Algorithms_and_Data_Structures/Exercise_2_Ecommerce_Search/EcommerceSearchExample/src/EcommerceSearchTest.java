import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Footwear"),
            new Product(4, "Shirt", "Clothing"),
            new Product(5, "Watch", "Accessories")
        };

        Product result1 = SearchAlgorithms.linearSearch(products, "Phone");
        System.out.println("Linear Search Result: " + result1);

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));

        Product result2 = SearchAlgorithms.binarySearch(sortedProducts, "Phone");
        System.out.println("Binary Search Result: " + result2);
    }
}
