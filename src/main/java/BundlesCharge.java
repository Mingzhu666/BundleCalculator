import lombok.Data;

@Data
public class BundlesCharge {
    private int[] numOfBundle;
    private double totalCost;

    public BundlesCharge(int[] numOfBundle, double totalCost) {
        this.numOfBundle = numOfBundle;
        this.totalCost = totalCost;
    }
}




