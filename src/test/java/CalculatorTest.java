import Controller.Calculator;
import Model.BundlesCharge;
import Model.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {
    @Test
    void testCalculateOrderCostIMG() throws IOException {
        //105 IMG
        String formatCode = "IMG";
        int numOfItem = 105;
        double expectedResult = 8450;
        ArrayList<Integer> expectedNumofBundle = new ArrayList<Integer>(Arrays.asList(1, 10));

        Calculator calculator = new Calculator();
        Order order = new Order();
        order.orderAdd(numOfItem, formatCode);
        List<BundlesCharge> calculateResult = calculator.CalculatorOrderCost(order);

        assertEquals(formatCode, calculateResult.get(0).getFormatCode());
        assertEquals(numOfItem, calculateResult.get(0).getNumOfItem());
        assertEquals(expectedNumofBundle, calculateResult.get(0).getNumOfBundle());
        assertEquals(expectedResult, calculateResult.get(0).getTotalCost());
    }

    @Test
    void testCalculateOrderCostVID() throws IOException {
        //127 VID
        String formatCode = "VID";
        int numOfItem = 127;
        double expectedResult = 21990;
        ArrayList<Integer> expectedNumofBundle = new ArrayList<Integer>(Arrays.asList(1, 0, 14));

        Calculator calculator = new Calculator();
        Order order = new Order();
        order.orderAdd(numOfItem, formatCode);
        List<BundlesCharge> calculateResult = calculator.CalculatorOrderCost(order);

        assertEquals(formatCode, calculateResult.get(0).getFormatCode());
        assertEquals(numOfItem, calculateResult.get(0).getNumOfItem());
        assertEquals(expectedNumofBundle, calculateResult.get(0).getNumOfBundle());
        assertEquals(expectedResult, calculateResult.get(0).getTotalCost());
    }

    @Test
    void testCalculateOrderCostFLAC() throws IOException {
        //321 AUDIO
        String formatCode = "FLAC";
        int numOfItem = 321;
        double expectedResult = 40972.5;
        ArrayList<Integer> expectedNumofBundle = new ArrayList<Integer>(Arrays.asList(0, 1, 35));

        Calculator calculator = new Calculator();
        Order order = new Order();
        order.orderAdd(numOfItem, formatCode);
        List<BundlesCharge> calculateResult = calculator.CalculatorOrderCost(order);

        assertEquals(formatCode, calculateResult.get(0).getFormatCode());
        assertEquals(numOfItem, calculateResult.get(0).getNumOfItem());
        assertEquals(expectedNumofBundle, calculateResult.get(0).getNumOfBundle());
        assertEquals(expectedResult, calculateResult.get(0).getTotalCost());
    }
}