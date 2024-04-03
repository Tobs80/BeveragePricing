import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class BeveragePricingTest {

    @Test
    @DisplayName("Get order total")
    void get_order_total() {
        //Example of the problem
        DecimalFormat df = new DecimalFormat("0.00");
        BeveragePricing BP = new BeveragePricing(5, 10000, 0 , 20000, 0);
        String total = df.format(BP.get_order_total());
        String subtotal = df.format(BP.get_order_subtotal());
        assertAll(() -> assertEquals("33070.80", total ),
                () -> assertEquals("35560.00", subtotal ));

        //Same example different ID
        BP.New_Order (1, 10000, 0 , 20000, 0);
        String total2 = df.format(BP.get_order_total());
        String subtotal2 = df.format(BP.get_order_subtotal());
        assertAll(() -> assertEquals("33106.36", total2 ),
                () -> assertEquals("35560.00", subtotal2 ));

        //Less than 30k
        BP.New_Order (4, 10000, 3230 , 5600, 7000);
        String total3 = df.format(BP.get_order_total());
        String subtotal3 = df.format(BP.get_order_subtotal());
        assertAll(() -> assertEquals("26185.41", total3 ),
                () -> assertEquals("26995.27", subtotal3 ));

        //Less than 10k
        BP.New_Order (3, 500, 100 , 60, 5600);
        String total4 = df.format(BP.get_order_total());
        String subtotal4 = df.format(BP.get_order_subtotal());
        assertAll(() -> assertEquals("7773.12", total4 ),
                () -> assertEquals("7464.53", subtotal4 ));

    }


    @Test
    void get_summary() {
        assertEquals(1,1);
    }
}