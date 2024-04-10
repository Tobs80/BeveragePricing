import java.text.DecimalFormat;

public class Order {
    static private Product A =  new Product("A", 0.52F, 0.80F, "%", 0);
    static private Product B =  new Product("B",0.38F, 1.20F,"%", 0.3F);
    static private Product C =  new Product("C",0.41F, 0.9F, "u",0);
    static private Product D =  new Product("D",0.60F, 1F, "u", 0.2F);

    static private Customer ID_1 = new Customer(0.05F, 0F,0.02F);
    static private Customer ID_2 = new Customer(0.04F, 0.01F,0.02F);
    static private Customer ID_3 = new Customer(0.03F, 0.01F,0.03F);
    static private Customer ID_4 = new Customer(0.02F, 0.03F,0.05F);
    static private Customer ID_5 = new Customer(0F, 0.05F,0.07F);
    private Customer[] Customers = {ID_1, ID_2, ID_3, ID_4, ID_5};
    private Product[] Products = {A,B,C,D};

    private int customer_id;
    private float order_subtotal, order_total;
    public Order(int customer_id, int qty_product_A,
                 int qty_product_B, int qty_product_C,
                 int qty_product_D)
    {
        this.customer_id = customer_id;
        A.set_qty(qty_product_A);
        B.set_qty(qty_product_B);
        C.set_qty(qty_product_C);
        D.set_qty(qty_product_D);
        this.calculate_order_total();
    }

    void  calculate_order_total()
    {
        this.order_subtotal = 0;
        for (Product product : Products)
        {
            this.order_subtotal += product.get_total();
        }
        float basic_discount = this.Customers[customer_id-1].get_basic_discount();
        //this.order_subtotal = this.order_subtotal * (1 - basic_discount);
        float bulk_discount = this.Customers[customer_id-1].get_bulk_discount(this.order_subtotal);
        this.order_total = this.order_subtotal * (1 - basic_discount) * (1 - bulk_discount);

    }

    public float get_order_total()
    {
        return this.order_total;
    }
    public float get_order_subtotal()
    {
        return this.order_subtotal;
    }
    public void get_summary()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Product | Qty | Base Unit Price | Total");
        for (Product product : Products)
            if (product.get_qty() > 0)
            {
                System.out.println(product.get_name() + " | " + product.get_qty() + " | " + df.format(product.get_unit_price()) + " | " + df.format(product.get_total()) + " | "  );
            }
        System.out.println("Total: " + df.format(this.get_order_subtotal()));
        System.out.println("Total after discount: " + df.format(this.get_order_total()));

    }

    public void New_Order(int customer_id,int qty_product_A,
                           int qty_product_B, int qty_product_C,
                           int qty_product_D)
    {
        this.customer_id = customer_id;
        A.set_qty(qty_product_A);
        B.set_qty(qty_product_B);
        C.set_qty(qty_product_C);
        D.set_qty(qty_product_D);
        this.calculate_order_total();
    }

}
