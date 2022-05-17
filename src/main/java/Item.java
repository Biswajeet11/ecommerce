import java.util.UUID;

public class Item {

    private String itemId;
    private int count;
    private double price;

    public Item(Product product, int count) {
        this.itemId = UUID.randomUUID().toString();
        this.count = count;
        this.price = product.getPrice();
    }

    public void updateCount(int newCount) {
        price = price * (newCount/count);
        count = newCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
