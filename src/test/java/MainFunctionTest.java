import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainFunctionTest {
    @Test
    void calculateCostTest() throws IOException {
        List<OrderItem> orderItems = new LinkedList<>();
        orderItems.add(new OrderItem(105, FormatCode.valueOf("IMG")));
        orderItems.add(new OrderItem(127, FormatCode.valueOf("VID")));
        List<BundlesCharge> bundlesCharges = Main.calculateCost(orderItems);
        List<BundlesCharge> bundlesChargesCompare = new LinkedList<>();
        bundlesChargesCompare.add(new BundlesCharge(new int[]{1, 10}, 8450));
        bundlesChargesCompare.add(new BundlesCharge(new int[]{1, 0, 14}, 21990));
        for (int i = 0; i < bundlesCharges.size(); i++) {
            assertEquals(bundlesCharges.get(i), bundlesChargesCompare.get(i));
        }
    }

    @Test
    void itemRegisterTestOne() throws IOException {
        HashMap<String, Integer> booking = new HashMap<String, Integer>();
        booking.put("IMG", 5);
        String[] processData = {"100", "IMG"};
        HashMap<String, Integer> itemRegisterCompare = new HashMap<String, Integer>();
        itemRegisterCompare.put("IMG", 105);
        HashMap<String, Integer> itemRegister = Main.itemRegister(booking, processData);
        assertEquals(itemRegisterCompare, itemRegister);
    }

    @Test
    void itemRegisterTestTwo() throws IOException {
        HashMap<String, Integer> booking = new HashMap<String, Integer>();
        booking.put("VID", 15);
        String[] processData = {"100", "IMG"};
        HashMap<String, Integer> itemRegisterCompare = new HashMap<String, Integer>();
        itemRegisterCompare.put("IMG", 100);
        itemRegisterCompare.put("VID", 15);
        HashMap<String, Integer> itemRegister = Main.itemRegister(booking, processData);
        assertEquals(itemRegisterCompare, itemRegister);
    }

    @Test
    void hashmapToListTestOne() throws IOException {
        HashMap<String, Integer> booking = new HashMap<String, Integer>();
        booking.put("IMG", 100);
        booking.put("VID", 15);
        List<OrderItem> bookingCompare = new LinkedList<>();
        bookingCompare.add(new OrderItem(15, FormatCode.valueOf("VID")));
        bookingCompare.add(new OrderItem(100, FormatCode.valueOf("IMG")));
        List<OrderItem> hashmapToList = Main.hashmapToList(booking);
        assertEquals(bookingCompare, hashmapToList);
    }

    @Test
    void hashmapToListTestTwo() throws IOException {
        HashMap<String, Integer> booking = new HashMap<String, Integer>();
        booking.put("IMG", 100);
        booking.put("VID", 15);
        booking.put("FLAC", 30);
        List<OrderItem> bookingCompare = new LinkedList<>();
        bookingCompare.add(new OrderItem(15, FormatCode.valueOf("VID")));
        bookingCompare.add(new OrderItem(100, FormatCode.valueOf("IMG")));
        bookingCompare.add(new OrderItem(30, FormatCode.valueOf("FLAC")));
        List<OrderItem> hashmapToList = Main.hashmapToList(booking);
        assertEquals(bookingCompare, hashmapToList);
    }
}
