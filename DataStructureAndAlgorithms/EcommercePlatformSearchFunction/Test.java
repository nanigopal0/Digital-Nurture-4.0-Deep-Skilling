package DataStructureAndAlgorithms.EcommercePlatformSearchFunction;

public class Test {
    public static void main(String[] args) {
        ProductSearchService searchService = new ProductSearchService();
        searchService.addProduct(new Product(1, "Apple airpods", "Headphone", 20, 13599));
        searchService.addProduct(new Product(2, "Macbook 15", "Laptop", 4, 130599));
        searchService.addProduct(new Product(3, "Google Pixel 19", "Mobile", 30, 53500));
        searchService.addProduct(new Product(4, "iPhone 20", "Mobile", 20, 13599));
        searchService.addProduct(new Product(5, "Wireless Mouse Keyboard Combo", "Electronics", 20, 1599));
        searchService.addProduct(new Product(6, "Duracell Battery Pack of 20", "Electronics", 20, 199));
        searchService.addProduct(new Product(7, "RAM 8GB DDR4", "Electronics", 20, 1599));
        searchService.addProduct(new Product(8, "AC", "Appliance", 20, 60000));
        searchService.addProduct(new Product(9, "TV", "TV", 20, 35999));
        searchService.addProduct(new Product(10, "LG Refrigerator", "Refrigerator", 20, 30299));

        System.out.println("All products: ");
        for(Product product: searchService.getProducts()){
            System.out.println(product);
        }
        System.out.println("---------------------------------------");
        Product linearSearchByProductId = searchService.linearSearchByProductId(6);
        System.out.println("Linear search by product id: " + linearSearchByProductId);
        Product binarySearchByProductId = searchService.binarySearchByProductId(9);
        System.out.println("Binary search by product id: " + binarySearchByProductId);
        Product binarySearchByProductName = searchService.binarySearchByProductName("LG Refrigerator");
        System.out.println("Binary search by product name: " + binarySearchByProductName);
        System.out.println("Linear search by product name: " + searchService.linearSearchByProductName("Macbook 15"));
    }
}
