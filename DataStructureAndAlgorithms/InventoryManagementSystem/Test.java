package DataStructureAndAlgorithms.InventoryManagementSystem;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        Product p1 = Product.Builder.builder().setProductId(1)
                .setProductName("Macbook Pro")
                .setQuantity(15)
                .setPrice(100000)
                .build();
        Product p2 = Product.Builder.builder().setProductId(4)
                .setProductName("iPhone 15 Pro Max")
                .setQuantity(6)
                .setPrice(180000)
                .build();
        service.addProduct(p1);
        service.addProduct(p2);
        service.addProduct(Product.Builder.builder()
                .setProductId(2)
                .setProductName("Pen")
                .setPrice(25)
                .setQuantity(500)
                .build());

        System.out.println("Product 4 before updating: " + service.getProduct(4));
        service.updateProduct(Product.Builder.builder()
                .setQuantity(2).setProductId(4).build());
        System.out.println("Product 4 after updating: " + service.getProduct(4));
        System.out.println("All products: " );
        printAllProducts(service.getAllProducts().values().stream().toList());
        System.out.println("Deleting product with id 1");
        service.deleteProduct(1);
        System.out.println("All products: ");
        printAllProducts(service.getAllProducts().values().stream().toList());
    }

    static void printAllProducts(List<Product> products) {
        for(Product p : products)
            System.out.println(p);
    }
}
