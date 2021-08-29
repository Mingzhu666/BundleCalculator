import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintResultTest {
    @Test
    void printResultTestOne() throws IOException {
        List<OrderItem> orderItems = new LinkedList<>();
        orderItems.add(new OrderItem(105, FormatCode.valueOf("IMG")));
        orderItems.add(new OrderItem(127, FormatCode.valueOf("VID")));
        orderItems.add(new OrderItem(321, FormatCode.valueOf("FLAC")));
        List<BundlesCharge> bundlesCharges = new LinkedList<>();
        bundlesCharges.add(new BundlesCharge(new int[]{1, 10}, 8450));
        bundlesCharges.add(new BundlesCharge(new int[]{1, 0, 14}, 21990));
        bundlesCharges.add(new BundlesCharge(new int[]{0, 1, 35}, 40972.5));
        String results = PrintResult.printResult(orderItems, bundlesCharges);
        results = results.replaceAll(" ", "");
        String resultsCompare =
                "105 IMG $8450.0" + "\n" +
                        "   10 x 10 $8000.0" + "\n" +
                        "   1 x 5 $450.0" + "\n" +
                        "127 VID $21990.0" + "\n" +
                        "   14 x 9 $21420.0" + "\n" +
                        "   1 x 3 $570.0" + "\n" +
                        "321 FLAC $40972.5" + "\n" +
                        "   35 x 9 $40162.5" + "\n" +
                        "   1 x 6 $810.0" + "\n";
        resultsCompare = resultsCompare.replaceAll(" ", "");
        assertEquals(resultsCompare, results);
    }
}