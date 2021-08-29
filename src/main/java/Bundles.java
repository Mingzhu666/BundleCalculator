import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

@Data
public class Bundles {
    private int[] numOfPost;
    private double[] costOfBundle;

    public Bundles(FormatCode formatCode) throws IOException {
        URL url = getClass()
                .getClassLoader()
                .getResource("config.properties");

        File file = new File(url.getFile());
        FileInputStream input = new FileInputStream(file);

        Properties prop = new Properties();
        prop.load(input);
        String[] numOfPostString = prop.getProperty(formatCode.toString().toLowerCase(Locale.ROOT) + "Bundle").split(",");
        this.numOfPost = new int[numOfPostString.length];
        for (int i = 0; i < numOfPostString.length; i++) {
            this.numOfPost[i] = Integer.parseInt(numOfPostString[i]);
        }
        String[] costOfBundleString = prop.getProperty(formatCode.toString().toLowerCase(Locale.ROOT) + "Cost").split(",");
        this.costOfBundle = new double[costOfBundleString.length];
        for (int i = 0; i < costOfBundleString.length; i++) {
            this.costOfBundle[i] = Double.parseDouble(costOfBundleString[i]);
        }
    }
}
