package service;

import entities.Bundle;

import java.util.stream.IntStream;

public class TotalPriceCalculator {
    public double calculateItemTotalCost(int[] bundlesCharge, Bundle bundle) {
        return IntStream.range(0, bundle.getNumOfPost().size()).mapToDouble(i -> bundlesCharge[i] * bundle.getCostOfBundle().get(i)).sum();
    }
}
