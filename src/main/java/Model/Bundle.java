package Model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Bundle {
    private ArrayList<Integer> numOfPost;
    private ArrayList<Double> costOfBundle;

    public Bundle() {
        this.numOfPost = new ArrayList<>();
        this.costOfBundle = new ArrayList<>();
    }

    public void numOfPostAdd(int post) {
        this.numOfPost.add(post);
    }

    public void costOfBundleAdd(double cost) {
        this.costOfBundle.add(cost);
    }
}
