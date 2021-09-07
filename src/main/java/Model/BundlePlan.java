package Model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

@Data
@Slf4j
public class BundlePlan {
    private HashMap<String, Bundle> bundlePlans;

    public BundlePlan() {
        bundlePlans = new HashMap<String, Bundle>();
        InputStream in = getClass()
                .getClassLoader().getResourceAsStream("Configuration.JSON");

        if (in == null)
            try {
                in = new FileInputStream(System.getProperty("user.dir") + "/resources/Configuration.JSON");
            } catch (Exception e) {
                log.error(e.toString());
            }

        JSONObject json = new JSONObject(new JSONTokener(in));
        Set<String> keys = json.keySet();

        keys.forEach((key) -> {
            Bundle bundle = new Bundle();
            JSONArray jsonNumofPostArray = json.getJSONObject(key).getJSONArray("Bundle");
            jsonNumofPostArray.forEach((postNumber) -> {
                bundle.numOfPostAdd((Integer) postNumber);
            });
            JSONArray jsonCostOfBundleArray = json.getJSONObject(key).getJSONArray("Cost");
            jsonCostOfBundleArray.forEach((bundlePrize) -> {
                bundle.costOfBundleAdd(Double.parseDouble(bundlePrize.toString()));
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
