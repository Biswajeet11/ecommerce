import java.util.UUID;

public class Product {

    private String productId;
    private String productName;
    private int quantity;
    private float rating;
    private double price;

    private Category category;

    private Seller seller;

    public Product(String productName, int quantity, float rating, Category category, Seller seller,double price) {
        this.productId = UUID.randomUUID().toString();
        this.productName = productName;
        this.quantity = quantity;
        this.rating = rating;
        this.category = category;
        this.seller = seller;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", category=" + category +
                ", seller=" + seller +
                '}';
    }

}
