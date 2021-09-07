package Controller;

import Model.BundlePlan;
import Model.Order;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class GetInput {
    public static HashMap<String, Integer> itemRegister(HashMap<String, Integer> booking, String[] processData) {
        if (Integer.parseInt(processData[0]) > 0) {
            if (booking.containsKey(processData[1].toUpperCase(Locale.ROOT))) {
                booking.put(processData[1].toUpperCase(Locale.ROOT), booking.get(processData[1].toUpperCase(Locale.ROOT)) + Integer.parseInt(processData[0]));
            } else {
                booking.put(processData[1].toUpperCase(Locale.ROOT), Integer.parseInt(processData[0]));
            }
        } else {
            log.error("Illegal input!");
        }
        return booking;
    }

    public static Order hashmapToOrder(HashMap<String, Integer> booking) {
        Order orders = new Order();
        booking.forEach((formatCode, numOfBundle) -> {
            try {
                orders.orderAdd(numOfBundle, formatCode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return orders;
    }

    public Order getOrder() {
        ArrayList<String> inputs = new ArrayList<>();

        String input;

        log.info("Enter something here : ");

        Scanner scanIn = new Scanner(System.in);
        while (scanIn.hasNextLine()) {
            input = scanIn.nextLine();

            if (input.equals("end")) {
                break;
            }
            inputs.add(input);
        }
        HashMap<String, Integer> booking = OrderParser(inputs);

        scanIn.close();
        return hashmapToOrder(booking);
    }

    public HashMap<String, Integer> OrderParser(ArrayList<String> inputs) {
        BundlePlan bundlePlan = new BundlePlan();
        HashMap<String, Integer> booking = new HashMap<String, Integer>();

        inputs.forEach((input) -> {
            try {
                String[] processData = input.split(" ");

                String formatCode = processData[1].toUpperCase(Locale.ROOT);
                if (!bundlePlan.keyCheck(formatCode)) {
                    log.error("invalid item detected!");
                } else if (Integer.parseInt(processData[0]) > 0) {
                    if (booking.containsKey(formatCode)) {
                        booking.put(formatCode, booking.get(formatCode) + Integer.parseInt(processData[0]));
                    } else {
                        booking.put(formatCode, Integer.parseInt(processData[0]));
                    }
                }
            } catch (Exception e) {
                log.error("Illegal input detected!");
                throw e;
            }
        });

        return booking;
    }
}
