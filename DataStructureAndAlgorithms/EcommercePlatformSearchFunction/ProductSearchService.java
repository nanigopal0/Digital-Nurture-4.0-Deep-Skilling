package DataStructureAndAlgorithms.EcommercePlatformSearchFunction;

import java.util.Arrays;

public class ProductSearchService {
    private static final Product[] products = new Product[10];
    private static int index = 0;

    private void sortById() {
        Arrays.sort(products, (a, b) -> a.getProductId() - b.getProductId());
    }

    private void sortByProductName() {
        Arrays.sort(products, (a, b) -> a.getProductName().compareTo(b.getProductName()));
    }

    public Product linearSearchByProductId(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public Product linearSearchByProductName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearchByProductId(int productId) {
        sortById();
        int low = 0, high = index;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() > productId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public Product binarySearchByProductName(String productName) {
        sortByProductName();
        int low = 0, high = index ;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].getProductName().equals(productName)) {
                return products[mid];
            } else if (products[mid].getProductName().compareTo(productName) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products[index++] = product;
    }

    public Product[] getProducts() {
        return products;
    }
}
