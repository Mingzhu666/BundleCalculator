import entities.BundlesCharge;
import entities.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.Calculator;
import service.OrderProcessor;
import service.TotalPriceCalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {
    private static Calculator calculator;
    private static TotalPriceCalculator totalPriceCalculator;

    @BeforeAll
    static void calculatorTestInitial(){
        calculator = new Calculator();
        totalPriceCalculator = new TotalPriceCalculator();
    }

    @Test
    void testCalculateOrderCostIMG() {
        //105 IMG
        String formatCode = "IMG";
        int numOfItem = 105;
        double expectedResult = 8450;
        ArrayList<Integer> expectedNumofBundle = new ArrayList<Integer>(Arrays.asList(1, 10));

        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order();
        order.addItem(numOfItem, formatCode);
        List<BundlesCharge> calculateResult = orderProcessor.processOrder(order, calculator, totalPriceCalculator);

        assertEquals(formatCode, calculateResult.get(0).getFormatCode());
        assertEquals(numOfItem, calculateResult.get(0).getNumOfItem());
        assertEquals(expectedNumofBundle, calculateResult.get(0).getNumOfBundle());
        assertEquals(expectedResult, calculateResult.get(0).getTotalCost());
    }

    @Test
    void testCalculateOrderCostVID() {
        //127 VID
        String formatCode = "VID";
        int numOfItem = 127;
        double expectedResult = 21990;
        ArrayList<Integer> expectedNumofBundle = new ArrayList<Integer>(Arrays.asList(1, 0, 14));

        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order();
        order.addItem(numOfItem, formatCode);
        List<BundlesCharge> calculateResult = orderProcessor.processOrder(order, calculator, totalPriceCalculator);

        assertEquals(formatCode, calculateResult.get(0).getFormatCode());
        assertEquals(numOfItem, calculateResult.get(0).getNumOfItem());
        assertEquals(expectedNumofBundle, calculateResult.get(0).getNumOfBundle());
        assertEquals(expectedResult, calculateResult.get(0).getTotalCost());
    }

    @Test
    void testCalculateOrderCostFLAC() {
        //321 AUDIO
        String formatCode = "FLAC";
        int numOfItem = 321;
        double expectedResult = 40972.5;
        ArrayList<Integer> expectedNumofBundle = new ArrayList<Integer>(Arrays.asList(0, 1, 35));

        OrderProcessor orderProcessor = new OrderProcessor();
        Order order = new Order();
        order.addItem(numOfItem, formatCode);
        List<BundlesCharge> calculateResult = orderProcessor.processOrder(order, calculator, totalPriceCalculator);

        assertEquals(formatCode, calculateResult.get(0).getFormatCode());
        assertEquals(numOfItem, calculateResult.get(0).getNumOfItem());
        assertEquals(expectedNumofBundle, calculateResult.get(0).getNumOfBundle());
        assertEquals(expectedResult, calculateResult.get(0).getTotalCost());
    }
}