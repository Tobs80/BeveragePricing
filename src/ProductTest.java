import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void get_unit_price() {
        DecimalFormat df = new DecimalFormat("0.00");
        Product A =  new Product("A", 0.52F, 0.80F, "%", 0);
        Product B =  new Product("B",0.38F, 1.20F,"%", 0.3F);
        Product C =  new Product("C",0.41F, 0.9F, "u",0);
        Product D =  new Product("D",0.60F, 1F, "u", 0.2F);
        A.set_qty(10000);
        B.set_qty(3230);
        C.set_qty(20000);
        D.set_qty(7000);
        assertAll(() -> assertEquals("0.94", df.format(A.get_unit_price())),
                () -> assertEquals("9360.00", df.format(A.get_total())),

                () -> assertEquals("0.59", df.format(B.get_unit_price())),
                () -> assertEquals("1890.20", df.format(B.get_total())),


                () -> assertEquals("1.31", df.format(C.get_unit_price())),
                () -> assertEquals("26200.00", df.format(C.get_total())),

                () -> assertEquals("1.28", df.format(D.get_unit_price())),
                () -> assertEquals("8960.00", df.format(D.get_total()))


        );
    }


    @Test
    void get_unit_cost() {
    }
}