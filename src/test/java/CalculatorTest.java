import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    void calculateTestOne() throws IOException {
        //105 IMG
        int numOfOrder = 105;
        double expectedResult = 8450;
        FormatCode formatCode = FormatCode.valueOf("IMG");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{1, 10}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateTestTwo() throws IOException {
        //101 IMG
        int numOfOrder = 101;
        double expectedResult = 8450;
        FormatCode formatCode = FormatCode.valueOf("IMG");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{1, 10}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateTestThree() throws IOException {
        //8 IMG
        int numOfOrder = 8;
        double expectedResult = 800;
        FormatCode formatCode = FormatCode.valueOf("IMG");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{0, 1}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateSumTestOne() throws IOException {
        int[] bundlesCharge = {1, 10};
        double expectedResult = 8450;
        FormatCode formatCode = FormatCode.valueOf("IMG");
        Bundles bundles = new Bundles(formatCode);
        double sum = Calculator.calculateSum(bundlesCharge, bundles);
        assertEquals(expectedResult, sum);
    }

    @Test
    void calculateSumTestTwo() throws IOException {
        int[] bundlesCharge = {0, 1};
        double expectedResult = 800;
        FormatCode formatCode = FormatCode.valueOf("IMG");
        Bundles bundles = new Bundles(formatCode);
        double sum = Calculator.calculateSum(bundlesCharge, bundles);
        assertEquals(expectedResult, sum);
    }

    @Test
    void calculateTestFour() throws IOException {
        //127 VID
        int numOfOrder = 127;
        double expectedResult = 21990;
        FormatCode formatCode = FormatCode.valueOf("VID");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{1, 0, 14}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateTestFive() throws IOException {
        //7 VID
        int numOfOrder = 7;
        double expectedResult = 1530;
        FormatCode formatCode = FormatCode.valueOf("VID");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{0, 0, 1}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateSumTestThree() throws IOException {
        int[] bundlesCharge = {1, 0, 14};
        double expectedResult = 21990;
        FormatCode formatCode = FormatCode.valueOf("VID");
        Bundles bundles = new Bundles(formatCode);
        double sum = Calculator.calculateSum(bundlesCharge, bundles);
        assertEquals(expectedResult, sum);
    }

    @Test
    void calculateSumTestFour() throws IOException {
        int[] bundlesCharge = {0, 0, 1};
        double expectedResult = 1530;
        FormatCode formatCode = FormatCode.valueOf("VID");
        Bundles bundles = new Bundles(formatCode);
        double sum = Calculator.calculateSum(bundlesCharge, bundles);
        assertEquals(expectedResult, sum);
    }

    @Test
    void calculateTestSix() throws IOException {
        //321 AUDIO
        int numOfOrder = 321;
        double expectedResult = 40972.5;
        FormatCode formatCode = FormatCode.valueOf("FLAC");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{0, 1, 35}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateTestSeven() throws IOException {
        //2 AUDIO
        int numOfOrder = 2;
        double expectedResult = 427.5;
        FormatCode formatCode = FormatCode.valueOf("FLAC");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{1, 0, 0}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateTestEight() throws IOException {
        //100 AUDIO
        int numOfOrder = 100;
        double expectedResult = 13050;
        FormatCode formatCode = FormatCode.valueOf("FLAC");
        BundlesCharge calculateResult = Calculator.calculate(numOfOrder, formatCode);
        assertArrayEquals(new int[]{1, 0, 11}, calculateResult.getNumOfBundle());
        assertEquals(expectedResult, calculateResult.getTotalCost());
    }

    @Test
    void calculateSumTestFive() throws IOException {
        int[] bundlesCharge = {1, 0, 0};
        double expectedResult = 427.5;
        FormatCode formatCode = FormatCode.valueOf("FLAC");
        Bundles bundles = new Bundles(formatCode);
        double sum = Calculator.calculateSum(bundlesCharge, bundles);
        assertEquals(expectedResult, sum);
    }

    @Test
    void calculateSumTestSix() throws IOException {
        int[] bundlesCharge = {1, 0, 11};
        double expectedResult = 13050;
        FormatCode formatCode = FormatCode.valueOf("FLAC");
        Bundles bundles = new Bundles(formatCode);
        double sum = Calculator.calculateSum(bundlesCharge, bundles);
        assertEquals(expectedResult, sum);
    }
}