import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {

    private String orderId;
    private List<Item> itemList;
    private OrderStatus currentOrderStatus;
    private Date orderTime;
    private String shippingAddress;
    private List<OrderLog> orderLogList;
    private double amount;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.orderLogList = new ArrayList<>();
        addOrderLogs(new OrderLog(OrderStatus.CREATED,new Date()));
    }

    public Shipment movetoShipment(){
        Shipment shipment = new Shipment(this);
        return shipment;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public OrderStatus getOrderStatus() {
        return currentOrderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.currentOrderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


    public OrderStatus getCurrentOrderStatus() {
        return currentOrderStatus;
    }

    public void setCurrentOrderStatus(OrderStatus currentOrderStatus) {
        this.currentOrderStatus = currentOrderStatus;
    }

    public List<OrderLog> getOrderLog() {
        return orderLogList;
    }

    public void setOrderLog(List<OrderLog> orderLog) {
        this.orderLogList = orderLog;
    }

    public void addOrderLogs(OrderLog orderlog) {
        this.orderLogList.add(orderlog);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", itemList=" + itemList +
                ", currentOrderStatus=" + currentOrderStatus +
                ", orderTime=" + orderTime +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", orderLogList=" + orderLogList +
                ", amount=" + amount +
                '}';
    }
}
