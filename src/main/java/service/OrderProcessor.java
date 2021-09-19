package service;

import entities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OrderProcessor {
    public List<BundlesCharge> processOrder(Order order, Calculator calculator, TotalPriceCalculator totalPriceCalculator) {
        List<BundlesCharge> bundlesCharges = new LinkedList<>();

        order.getOrderItems().forEach((orderItem) -> {
            BundlesCharge bundlesCharge = processOrderItem(orderItem, calculator, totalPriceCalculator);
            bundlesCharges.add(bundlesCharge);
        });

        return bundlesCharges;
    }

    public BundlesCharge processOrderItem(OrderItem orderItem, Calculator calculator, TotalPriceCalculator totalPriceCalculator) {
        BundlePlan bundlePlan = new BundlePlan();
        String formatCode = orderItem.getFormatCode();

        Bundle bundle = bundlePlan.getBundle(formatCode);
        int length = bundle.getNumOfPost().size();


        int[] bundlesChargeArray = calculator.calculate(orderItem.getNumOfItem(), new int[length], length - 1, bundle);

        double totalCost = totalPriceCalculator.calculateItemTotalCost(bundlesChargeArray, bundle);

        List<Integer> bundlesChargeList = new ArrayList<>();

        Arrays.stream(bundlesChargeArray).forEach(bundlesCharge -> bundlesChargeList.add(bundlesCharge));

        return new BundlesCharge(formatCode, orderItem.getNumOfItem(), bundlesChargeList, totalCost);
    }
}
