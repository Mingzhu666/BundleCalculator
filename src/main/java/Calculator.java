import java.io.IOException;

public class Calculator {
    public static BundlesCharge calculate(int numOfOrder, FormatCode formatCode) throws IOException {
        Bundles bundles = new Bundles(formatCode);
        int[] bundlesCharge = new int[bundles.getNumOfPost().length];
        int i = bundles.getNumOfPost().length - 1;
        int orderNum = numOfOrder;

        while (orderNum > 0) {
            bundlesCharge[i] = orderNum / bundles.getNumOfPost()[i];
            orderNum = orderNum % bundles.getNumOfPost()[i];
            if (i > 0 && orderNum > bundles.getNumOfPost()[i - 1]) {
                bundlesCharge[i] += 1;
                break;
            }
            i--;
            if (orderNum < bundles.getNumOfPost()[0] && orderNum > 0) {
                bundlesCharge[0]++;
                break;
            }
        }
        double totalCost = calculateSum(bundlesCharge, bundles);
        return new BundlesCharge(bundlesCharge, totalCost);
    }

    public static double calculateSum(int[] bundlesCharge, Bundles bundles) {
        double result = 0;
        for (int i = 0; i < bundles.getNumOfPost().length; i++) {
            result += bundlesCharge[i] * bundles.getCostOfBundle()[i];
        }
        return result;
    }
}
