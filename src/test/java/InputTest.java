import Controller.GetInput;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    private static HashMap<String, Integer> booking;

    @BeforeAll
    static void InputInitial() {
        ArrayList<String> userInput = new ArrayList<>();
        userInput.add("10 IMG");
        userInput.add("15 Vid");
        userInput.add("30 flac");

        GetInput getInput = new GetInput();
        booking = getInput.OrderParser(userInput);
    }

    @Test
    void testOrderParserIMG_legalInput() {
        assertEquals(10, booking.get("IMG"));
    }

    @Test
    void testOrderParserVID_legalInput() {
        assertEquals(15, booking.get("VID"));
    }

    @Test
    void testOrderParserFLAC_legalInput() {
        assertEquals(30, booking.get("FLAC"));
    }

    @Test
    void testOrderParser_illegalInput() {
        BasicConfigurator.configure();

        ArrayList<String> userInput = new ArrayList<>();
        userInput.add("123456");
        GetInput getInput = new GetInput();
        assertThrows(Exception.class, () ->
                getInput.OrderParser(userInput));
    }

}
