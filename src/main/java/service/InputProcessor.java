package service;

import entities.BundlePlan;
import entities.Order;
import entities.OrderItem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
public class InputProcessor {
    public Order convertHashmapToOrder(List<OrderItem> booking) {
        Order orders = new Order();

        booking.stream().
                forEach(orderItem -> orders.addItem(orderItem));

        return orders;
    }

    public Order getOrder() {
        ArrayList<String> inputs = new ArrayList<>();

        String input;

        log.info("Enter something here : ");

        try (Scanner scanIn = new Scanner(System.in)){
            while (scanIn.hasNextLine()) {
                input = scanIn.nextLine();

                if (input.equals("end")) {
                    break;
                }
                inputs.add(input);
            }

            List<OrderItem> booking = orderParser(inputs);
            scanIn.close();
            return convertHashmapToOrder(booking);
        }
        catch (Exception e){
            log.error("Input detect error", e);
        }

        return convertHashmapToOrder(new ArrayList<>());
    }

    public List<OrderItem> orderParser(List<String> inputs) {
        BundlePlan bundlePlan = new BundlePlan();

        try {
            return inputs.stream()
                    .filter(input -> bundlePlan.keyCheck(input.split(" ")[1].toUpperCase(Locale.ROOT)))
                    .map(input -> new OrderItem(Integer.parseInt(input.split(" ")[0]), input.split(" ")[1].toUpperCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            log.error("Illegal input detected. System exit", e);
            System.exit(1);
        }

        return new ArrayList<>();
    }
}
