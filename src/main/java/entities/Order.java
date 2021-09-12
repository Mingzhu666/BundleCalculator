package entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private List<OrderItem> orderItems;

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    public void addItem(int numOfItem, String formatCode) {
        this.orderItems.add(new OrderItem(numOfItem, formatCode));
    }

    public void addItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }
}
