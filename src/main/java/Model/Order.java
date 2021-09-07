package Model;

import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;

@Data
public class Order {
    ArrayList<OrderItem> orderItems;

    public Order(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    public void orderAdd(int numOfItem, String formatCode) throws IOException {
        this.orderItems.add(new OrderItem(numOfItem, formatCode));
    }
}
