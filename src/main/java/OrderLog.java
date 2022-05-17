import java.util.Date;

public class OrderLog {

    private OrderStatus status;
    private Date orderTime;

    public OrderLog(OrderStatus status, Date orderTime) {
        this.status = status;
        this.orderTime = orderTime;
    }
}
