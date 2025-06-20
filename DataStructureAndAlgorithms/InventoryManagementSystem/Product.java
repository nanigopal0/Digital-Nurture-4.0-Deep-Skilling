package DataStructureAndAlgorithms.InventoryManagementSystem;


public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;


    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Product Id: " + productId + ", Product Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }

    static class Builder {
        private int productId;
        private String productName;
        private int quantity;
        private double price;
        private static Builder builder;

        private Builder() {
        }

        public static Builder builder() {
            if (builder == null) builder = new Builder();
            return builder;
        }

        public Builder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public void reset() {
            this.productId = 0;
            this.productName = null;
            this.quantity = 0;
            this.price = 0;
        }

        public Product build() {
            Product product = new Product(this);
            reset();
            return product;
        }
    }

}
