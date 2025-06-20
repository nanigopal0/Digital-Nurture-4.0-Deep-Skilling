package DataStructureAndAlgorithms.InventoryManagementSystem;

import java.util.HashMap;

public class ProductService {
    private static final HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        Product old = getProduct(product.getProductId());
        Product.Builder builder = Product.Builder.builder().setProductId(product.getProductId());
        builder.setProductName(product.getProductName() != null ? product.getProductName() : old.getProductName());
        builder.setPrice(product.getPrice() != 0 ? product.getPrice() : old.getPrice());
        builder.setQuantity(product.getQuantity() != 0 ? product.getQuantity() : old.getQuantity());
        products.put(product.getProductId(), builder.build());
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public HashMap<Integer, Product> getAllProducts() {
        return products;
    }
}
