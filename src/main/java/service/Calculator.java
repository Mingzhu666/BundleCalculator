package service;

import entities.Bundle;

public class Calculator {
    public int[] calculate(int itemLeft, int[] result, int pointer, Bundle bundle) {
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

    public double calculateItemTotalCost(int[] bundlesCharge, Bundle bundle) {
        double result = 0;
        for (int i = 0; i < bundle.getNumOfPost().size(); i++) {
            result += bundlesCharge[i] * bundle.getCostOfBundle().get(i);
        }
        return result;
    }


}
