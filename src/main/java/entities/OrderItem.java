package entities;

import lombok.Data;

@Data
public class OrderItem {
    private int numOfItem;
    private String formatCode;

    public OrderItem(int numOfItem, String formatCode) {
        this.numOfItem = numOfItem;
        this.formatCode = formatCode;
    }
}
