package service;

import entities.Bundle;
import entities.BundlePlan;
import entities.BundlesCharge;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
//printer
public class OrderResultPrinter {
    public void printResult(List<BundlesCharge> bundlesCharges) {
        bundlesCharges.forEach(bundlesCharge -> {

            log.info(bundlesCharge.getNumOfItem() + " " + bundlesCharge.getFormatCode() + " $" + bundlesCharge.getTotalCost());


            Bundle bundles = new BundlePlan().getBundle(bundlesCharge.getFormatCode());
            List<Double> costOfBundle = bundles.getCostOfBundle();

            IntStream.iterate(costOfBundle.size() - 1, i -> i - 1).limit(costOfBundle.size())
                    .filter(i -> bundlesCharge.getNumOfBundle().get(i) > 0)
                    .forEach(i -> {
                    log.info("   " + bundlesCharge.getNumOfBundle().get(i) + " x " + bundles.getNumOfPost().get(i) + " $" + bundlesCharge.getNumOfBundle().get(i) * bundles.getCostOfBundle().get(i));
            });
        });
    }
}
