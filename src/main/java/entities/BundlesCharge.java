package entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BundlesCharge {
    private String formatCode;
    private int numOfItem;
    private List<Integer> numOfBundle;
    private double totalCost;

    public BundlesCharge(String formatCode, int numofItem, List<Integer> numOfBundle, double totalCost) {
        this.formatCode = formatCode;
        this.numOfItem = numofItem;
        this.numOfBundle = numOfBundle;
        this.totalCost = totalCost;
    }
}




