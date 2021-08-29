import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getGlobal();
        List<OrderItem> orderItems = getOrderItems();
        List<BundlesCharge> bundlesCharges = calculateCost(orderItems);
        logger.info(PrintResult.printResult(orderItems, bundlesCharges));
    }

    public static List<BundlesCharge> calculateCost(List<OrderItem> orderItems) throws IOException {
        List<BundlesCharge> bundlesCharges = new LinkedList<>();
        orderItems.forEach((orderItem) -> {
            BundlesCharge bundlesCharge = null;
            try {
                bundlesCharge = Calculator.calculate(orderItem.getNumOfItem(), orderItem.getFormatCode());
            } catch (IOException e) {
                e.printStackTrace();
            }
            bundlesCharges.add(bundlesCharge);
        });
        return bundlesCharges;
    }

    public static @NotNull List<OrderItem> getOrderItems() {
        Logger logger = Logger.getGlobal();
        logger.info("Enter something here : ");
        String input;
        HashMap<String, Integer> booking = new HashMap<String, Integer>();
        Scanner scanIn = new Scanner(System.in);
        while (scanIn.hasNextLine()) {
            input = scanIn.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.trim().isEmpty()) {
                logger.warning("Illegal input!");
                continue;
            }
            String[] processData = input.split(" ");
            booking = itemRegister(booking, processData);
        }
        scanIn.close();
        return hashmapToList(booking);
    }

    public static HashMap<String, Integer> itemRegister(HashMap<String, Integer> booking, String[] processData) {
        Logger logger = Logger.getGlobal();
        if (Integer.parseInt(processData[0]) > 0) {
            if (booking.containsKey(processData[1].toUpperCase(Locale.ROOT))) {
                booking.put(processData[1].toUpperCase(Locale.ROOT), booking.get(processData[1].toUpperCase(Locale.ROOT)) + Integer.parseInt(processData[0]));
            } else {
                booking.put(processData[1].toUpperCase(Locale.ROOT), Integer.parseInt(processData[0]));
            }
        } else {
            logger.warning("Illegal input!");
        }
        return booking;
    }

    public static List<OrderItem> hashmapToList(HashMap<String, Integer> booking) {
        List<OrderItem> orders = new LinkedList<>();
        booking.forEach((formatCode, numOfBundle) -> {
            try {
                OrderItem order = new OrderItem(numOfBundle, FormatCode.valueOf(formatCode));
                orders.add(order);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return orders;
    }
}
