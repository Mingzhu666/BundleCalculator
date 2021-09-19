package entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@Slf4j
public class BundlePlan {
    private Map<String, Bundle> bundlePlans;

    public BundlePlan() {
        bundlePlans = new HashMap<>();
        InputStream in = getClass()
                .getClassLoader().getResourceAsStream("Configuration.JSON");

        if (in == null)
            try {
                in = new FileInputStream(System.getProperty("user.dir") + "/resources/Configuration.JSON");
            } catch (FileNotFoundException e) {
                log.error("Cannot find order", e);
            }

        JSONObject json = new JSONObject(new JSONTokener(in));
        Set<String> keys = json.keySet();

        keys.forEach((key) -> {
            Bundle bundle = new Bundle();
            JSONArray jsonNumbPostArray = json.getJSONObject(key).getJSONArray("Bundle");
            jsonNumbPostArray.forEach((postNumber) -> {
                bundle.addNumOfPost((Integer) postNumber);
            });
            JSONArray jsonCostOfBundleArray = json.getJSONObject(key).getJSONArray("Cost");
            jsonCostOfBundleArray.forEach((bundlePrize) -> {
                bundle.addCostOfBundle(Double.parseDouble(bundlePrize.toString()));
            });

            this.bundlePlans.put(key, bundle);
        });
    }

    public boolean keyCheck(String key) {
        return this.bundlePlans.containsKey(key);
    }

    public Bundle getBundle(String key) {
        return this.bundlePlans.get(key);
    }
}
