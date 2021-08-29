import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BundlesTest {
    @Test
    void BundlesTestImg() throws IOException {
        FormatCode formatCode = FormatCode.valueOf("IMG");
        Bundles bundles = new Bundles(formatCode);
        assertArrayEquals(new int[]{5, 10}, bundles.getNumOfPost());
        assertArrayEquals(new double[]{450.0, 800.0}, bundles.getCostOfBundle());
    }

    @Test
    void BundlesTestFlac() throws IOException {
        FormatCode formatCode = FormatCode.valueOf("FLAC");
        Bundles bundles = new Bundles(formatCode);
        assertArrayEquals(new int[]{3, 6, 9}, bundles.getNumOfPost());
        assertArrayEquals(new double[]{427.50, 810, 1147.50}, bundles.getCostOfBundle());
    }

    @Test
    void BundlesTestVid() throws IOException {
        FormatCode formatCode = FormatCode.valueOf("VID");
        Bundles bundles = new Bundles(formatCode);
        assertArrayEquals(new int[]{3, 5, 9}, bundles.getNumOfPost());
        assertArrayEquals(new double[]{570, 900, 1530}, bundles.getCostOfBundle());
    }
}