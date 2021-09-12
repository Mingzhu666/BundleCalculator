import entities.BundlesCharge;
import entities.Order;
import org.apache.log4j.BasicConfigurator;
import service.InputProcessor;
import service.OrderProcessor;
import service.OrderResultPrinter;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        BasicConfigurator.configure();

        InputProcessor in = new InputProcessor();
        Order order = in.getOrder();

        OrderProcessor orderProcessor = new OrderProcessor();
        List<BundlesCharge> bundlesCharges = orderProcessor.processOrder(order);

        OrderResultPrinter orderResultPrinter = new OrderResultPrinter();
        orderResultPrinter.printResult(bundlesCharges);
    }


}
