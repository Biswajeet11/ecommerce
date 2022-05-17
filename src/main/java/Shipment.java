import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Shipment {

    private String shipmentId;
    private Order order;
    private LocalDateTime date;
    private LocalDateTime arrivalDate;

    public Shipment(Order order) {
        this.shipmentId = UUID.randomUUID().toString();
        this.order = order;
        this.date = LocalDateTime.now();
        this.arrivalDate = this.date.plusDays(3);
        order.setOrderStatus(OrderStatus.SHIPPED);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", order=" + order +
                ", date=" + date +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
