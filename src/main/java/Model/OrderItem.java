package Model;

import lombok.Data;

import java.io.IOException;

@Data
public class OrderItem {
    private int numOfItem;
    private String formatCode;

    public OrderItem(int numOfItem, String formatCode) throws IOException {
        this.numOfItem = numOfItem;
        this.formatCode = formatCode;
    }
}
