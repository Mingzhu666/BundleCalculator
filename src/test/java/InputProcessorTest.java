import entities.OrderItem;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.InputProcessor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputProcessorTest {
    private static List<OrderItem> booking;

    @BeforeAll
    static void InputInitial() {
        ArrayList<String> userInput = new ArrayList<>();
        userInput.add("10 IMG");
        userInput.add("15 Vid");
        userInput.add("30 flac");

        InputProcessor inputProcessor = new InputProcessor();
        booking = inputProcessor.orderParser(userInput);
    }

    @Test
    void testOrderParserIMG_legalInput() {
        OrderItem orderItem = new OrderItem(10, "IMG");
        assertEquals(orderItem, booking.get(0));
    }

    @Test
    void testOrderParserVID_legalInput() {
        OrderItem orderItem = new OrderItem(15, "VID");
        assertEquals(orderItem, booking.get(1));
    }

    @Test
    void testOrderParserFLAC_legalInput() {
        OrderItem orderItem = new OrderItem(30, "FLAC");
        assertEquals(orderItem, booking.get(2));
    }

    @Test
    void testOrderParser_illegalInput() {
        BasicConfigurator.configure();

        ArrayList<String> userInput = new ArrayList<>();
        userInput.add("123456");
        InputProcessor inputProcessor = new InputProcessor();
        assertThrows(Exception.class, () ->
                inputProcessor.orderParser(userInput));
    }

}
