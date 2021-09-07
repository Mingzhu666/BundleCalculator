package Controller;

import Model.Bundle;
import Model.BundlePlan;
import Model.BundlesCharge;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PrintResult {
    public void printResult(List<BundlesCharge> bundlesCharges) {
        bundlesCharges.forEach(bundlesCharge -> {

            log.info(bundlesCharge.getNumOfItem() + " " + bundlesCharge.getFormatCode() + " $" + bundlesCharge.getTotalCost());


            Bundle bundles = new BundlePlan().getBundle(bundlesCharge.getFormatCode());
            ArrayList<Double> costOfBundle = bundles.getCostOfBundle();

            for (int i = costOfBundle.size() - 1; i >= 0; i--) {
                if (bundlesCharge.getNumOfBundle().get(i) > 0) {
                    log.info("   " + bundlesCharge.getNumOfBundle().get(i) + " x " + bundles.getNumOfPost().get(i) + " $" + bundlesCharge.getNumOfBundle().get(i) * bundles.getCostOfBundle().get(i));
                }
            }
        });
    }
}
