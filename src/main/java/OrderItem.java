import lombok.Data;

import java.io.IOException;

@Data
public class OrderItem {
    private int numOfItem;
    private FormatCode formatCode;

    public OrderItem(int numOfItem, FormatCode formatCode) throws IOException {
        this.numOfItem = numOfItem;
        this.formatCode = formatCode;
    }
}
