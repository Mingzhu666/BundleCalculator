package Controller;

import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    public static int[] calculate(int itemLeft, int[] result, int pointer, Bundle bundle) {
        result[pointer] = itemLeft / bundle.getNumOfPost().get(pointer);
        itemLeft = itemLeft % bundle.getNumOfPost().get(pointer);

        if (itemLeft <= 0)
            return result;

        if (pointer > 0 && itemLeft > bundle.getNumOfPost().get(pointer - 1)) {
            result[pointer] += 1;
            return result;
        }

        if (itemLeft < bundle.getNumOfPost().get(0) && itemLeft > 0) {
            result[0]++;
            return result;
        }

        return calculate(itemLeft, result, --pointer, bundle);
    }

    public static double calculateItemTotalCost(int[] bundlesCharge, Bundle bundle) {
        double result = 0;
        for (int i = 0; i < bundle.getNumOfPost().size(); i++) {
            result += bundlesCharge[i] * bundle.getCostOfBundle().get(i);
        }
        return result;
    }

    public List<BundlesCharge> CalculatorOrderCost(Order order) {
        List<BundlesCharge> bundlesCharges = new LinkedList<>();

        order.getOrderItems().forEach((orderItem) -> {
            BundlesCharge bundlesCharge = null;
            try {
                bundlesCharge = calculateOrderItem(orderItem);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bundlesCharges.add(bundlesCharge);
        });

        return bundlesCharges;
    }

    public BundlesCharge calculateOrderItem(OrderItem orderItem) throws IOException {
        BundlePlan bundlePlan = new BundlePlan();
        String formatCode = orderItem.getFormatCode();

        Bundle bundle = bundlePlan.getBundle(formatCode);
        int length = bundle.getNumOfPost().size();

        int[] bundlesCharge = calculate(orderItem.getNumOfItem(), new int[length], length - 1, bundle);

        double totalCost = calculateItemTotalCost(bundlesCharge, bundle);

        ArrayList<Integer> bundlesChargeTmp = new ArrayList<Integer>();

        for (int tmp : bundlesCharge) {
            bundlesChargeTmp.add(tmp);
        }

        return new BundlesCharge(formatCode, orderItem.getNumOfItem(), bundlesChargeTmp, totalCost);
    }
}
