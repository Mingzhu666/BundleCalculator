package service;

import entities.BundlePlan;
import entities.Order;
import entities.OrderItem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class InputProcessor {
    public Order hashmapToOrder(List<OrderItem> booking) {
        Order orders = new Order();
        booking.forEach(orderItem -> {
            orders.addItem(orderItem);
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

        List<OrderItem> booking = orderParser(inputs);

        scanIn.close();
        return hashmapToOrder(booking);
    }

    public List<OrderItem> orderParser(ArrayList<String> inputs) {
        BundlePlan bundlePlan = new BundlePlan();
        List<OrderItem> booking = new ArrayList<>();

        inputs.forEach((input) -> {
            try {
                String[] processData = input.split(" ");

                String formatCode = processData[1].toUpperCase(Locale.ROOT);
                int numOfBooking = Integer.parseInt(processData[0]);
                if (bundlePlan.keyCheck(formatCode)) {
                    booking.add(new OrderItem(numOfBooking, formatCode));
                } else {
                    log.warn("invalid item detected! The item '" + formatCode + "' will be skipped.");
                }
            } catch (Exception e) {
                log.error("Illegal input detected!", e);
                throw e;
            }
        });

        return booking;
    }
}
