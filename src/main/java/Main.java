import entities.BundlesCharge;
import entities.Order;
import org.apache.log4j.BasicConfigurator;
import service.*;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        BasicConfigurator.configure();

        InputProcessor in = new InputProcessor();
        Order order = in.getOrder();

        Calculator calculator = new Calculator();
        TotalPriceCalculator totalPriceCalculator = new TotalPriceCalculator();
        OrderProcessor orderProcessor = new OrderProcessor();
        List<BundlesCharge> bundlesCharges = orderProcessor.processOrder(order, calculator, totalPriceCalculator);

        OrderResultPrinter orderResultPrinter = new OrderResultPrinter();
        orderResultPrinter.printResult(bundlesCharges);
    }


}
