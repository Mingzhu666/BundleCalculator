import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class PrintResult {
    public static String printResult(List<OrderItem> orderItems, List<BundlesCharge> bundlesCharges) {
        AtomicReference<String> results = new AtomicReference<>("");
        IntStream.range(0, orderItems.size())
                .forEach(index -> {
                    OrderItem orderitem = orderItems.get(index);
                    BundlesCharge bundlesCharge = bundlesCharges.get(index);

                    String result = orderitem.getNumOfItem() + " " + orderitem.getFormatCode().toString() + " $" + bundlesCharge.getTotalCost() + "\n";
                    int[] numOfBundle = bundlesCharge.getNumOfBundle();
                    Bundles bundles = null;
                    try {
                        bundles = new Bundles(orderitem.getFormatCode());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    double[] costOfBundle = bundles.getCostOfBundle();
                    for (int i = bundlesCharge.getNumOfBundle().length - 1; i >= 0; i--) {
                        if (bundlesCharge.getNumOfBundle()[i] > 0) {
                            result += "   " + numOfBundle[i] + " x " + bundles.getNumOfPost()[i] + " $" + numOfBundle[i] * costOfBundle[i] + "\n";
                        }
                    }
                    results.set(results.get() + result);
                });
        return results.get();
    }
}
