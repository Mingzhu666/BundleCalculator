package Model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BundlesCharge {
    private String formatCode;
    private int numOfItem;
    private ArrayList<Integer> numOfBundle;
    private double totalCost;

    public BundlesCharge(String formatCode, int numofItem, ArrayList<Integer> numOfBundle, double totalCost) {
        this.formatCode = formatCode;
        this.numOfItem = numofItem;
        this.numOfBundle = numOfBundle;
        this.totalCost = totalCost;
    }
}




