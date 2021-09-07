import Controller.Calculator;
import Controller.GetInput;
import Controller.PrintResult;
import Model.BundlesCharge;
import Model.Order;
import org.apache.log4j.BasicConfigurator;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        BasicConfigurator.configure();

        GetInput in = new GetInput();
        Order order = in.getOrder();

        Calculator calculator = new Calculator();
        List<BundlesCharge> bundlesCharges = calculator.CalculatorOrderCost(order);

        PrintResult printResult = new PrintResult();
        printResult.printResult(bundlesCharges);
    }


}
