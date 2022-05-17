import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends User {

    private Cart cart;
    private Order currentOrder;
    private List<Order> orderHistory;

    public Customer(String name, String address) {
        super(name, address);
        cart = new Cart();
        orderHistory = new ArrayList<>();
    }

    public void addToCart(Item item) {
        this.cart.addToCart(item);
    }

    public void removeFromCart(Item item) {
        this.cart.removeItem(item);
    }

    public void clearCart() {
        this.cart.clearCart();
    }

    public void printCartItems() {
        System.out.println(this.cart.getItemList());
    }

    public void updateCartItems(Item item, int newQuantity ) {
        this.cart.updateCart(item,newQuantity);
    }

    public void placeOrder(){
        currentOrder = new Order();
        currentOrder.setOrderStatus(OrderStatus.CREATED);
        currentOrder.setOrderTime(new Date());

        List<Item> orderItems = this.cart.getItemList();
        double orderAmount =0;

        for(Item item : orderItems){
            orderAmount += item.getPrice();
        }

        currentOrder.setItemList(orderItems);
        currentOrder.setAmount(orderAmount);
        currentOrder.setShippingAddress(this.getAddress());
        this.orderHistory.add(currentOrder);
    }

    public List<Order> getOrderHistory(){
        return orderHistory;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

}
