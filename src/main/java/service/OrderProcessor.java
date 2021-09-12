package service;

import entities.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderProcessor {
    public List<BundlesCharge> processOrder(Order order) {
        List<BundlesCharge> bundlesCharges = new LinkedList<>();

        order.getOrderItems().forEach((orderItem) -> {
            BundlesCharge bundlesCharge = processOrderItem(orderItem);
            bundlesCharges.add(bundlesCharge);
        });

        return bundlesCharges;
    }

    public BundlesCharge processOrderItem(OrderItem orderItem) {
        BundlePlan bundlePlan = new BundlePlan();
        String formatCode = orderItem.getFormatCode();

        Bundle bundle = bundlePlan.getBundle(formatCode);
        int length = bundle.getNumOfPost().size();

        Calculator calculator = new Calculator();
        int[] bundlesCharge = calculator.calculate(orderItem.getNumOfItem(), new int[length], length - 1, bundle);

        double totalCost = calculator.calculateItemTotalCost(bundlesCharge, bundle);

        ArrayList<Integer> bundlesChargeTmp = new ArrayList<>();

        for (int tmp : bundlesCharge) {
            bundlesChargeTmp.add(tmp);
        }

        return new BundlesCharge(formatCode, orderItem.getNumOfItem(), bundlesChargeTmp, totalCost);
    }
}
