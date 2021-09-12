import entities.Bundle;
import entities.BundlePlan;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class BundlesPlanTest {
    @Test
    void testBundleIMGInitial_Pass() {
        String formatCode = "IMG";
        BundlePlan bundlePlan = new BundlePlan();
        Bundle bundle = bundlePlan.getBundle(formatCode);
        assertEquals(new ArrayList<Integer>(Arrays.asList(5, 10)), bundle.getNumOfPost());
        assertEquals(new ArrayList<Double>(Arrays.asList(450.0, 800.0)), bundle.getCostOfBundle());
    }

    @Test
    void testBundlesFLACInitial_Pass() {
        String formatCode = "FLAC";
        BundlePlan bundlePlan = new BundlePlan();
        Bundle bundle = bundlePlan.getBundle(formatCode);
        assertEquals(new ArrayList<Integer>(Arrays.asList(3, 6, 9)), bundle.getNumOfPost());
        assertEquals(new ArrayList<Double>(Arrays.asList(427.50, 810.0, 1147.50)), bundle.getCostOfBundle());
    }

    @Test
    void testBundlesVIDInitial_Pass() {
        String formatCode = "VID";
        BundlePlan bundlePlan = new BundlePlan();
        Bundle bundle = bundlePlan.getBundle(formatCode);
        assertEquals(new ArrayList<Integer>(Arrays.asList(3, 6, 9)), bundle.getNumOfPost());
        assertEquals(new ArrayList<Double>(Arrays.asList(570.0, 900.0, 1530.0)), bundle.getCostOfBundle());
    }

    @Test
    void testKeyCheck_HasKey() {
        BundlePlan bundlePlan = new BundlePlan();
        assertTrue(bundlePlan.keyCheck("IMG"));
    }

    @Test
    void testKeyCheck_NoKey() {
        BundlePlan bundlePlan = new BundlePlan();
        assertFalse(bundlePlan.keyCheck("AVA"));
    }

    @Test
    void testGetIMGBundle_Pass() {
        BundlePlan bundlePlan = new BundlePlan();

        Bundle bundle = new Bundle();
        bundle.addNumOfPost(5);
        bundle.addNumOfPost(10);

        bundle.addCostOfBundle(450);
        bundle.addCostOfBundle(800);
        assertEquals(bundle, bundlePlan.getBundle("IMG"));
    }
}
