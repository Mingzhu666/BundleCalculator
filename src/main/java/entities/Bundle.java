package entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bundle {
    private List<Integer> numOfPost;
    private List<Double> costOfBundle;

    public Bundle() {
        this.numOfPost = new ArrayList<>();
        this.costOfBundle = new ArrayList<>();
    }

    public void addNumOfPost(int post) {
        this.numOfPost.add(post);
    }

    public void addCostOfBundle(double cost) {
        this.costOfBundle.add(cost);
    }
}
