class Product {
    private String name;
    private float unit_cost, markup, promotion, total;
    private String markup_type;

    private float unit_price = 0;
    private int qty;


    public Product(String name, float unit_cost, float markup, String markup_type, float promotion)
    {
        this.name = name;
        this.unit_cost = unit_cost;
        this.markup = markup;
        this.markup_type = markup_type;
        this.promotion = promotion;
        this.calculate_unit_price();
    }


    private void calculate_unit_price()
    {
        if (this.markup_type.equals("%"))
        {
            this.unit_price = this.unit_cost * (1 + this.markup) * (1 - this.promotion);
        }
        else if (this.markup_type.equals("u"))
        {
            this.unit_price = (this.unit_cost + this.markup) * (1 - this.promotion);
        }
    }

    public float get_unit_price()
    {
        return this.unit_price;
    }
    public float get_unit_cost()
    {
        return this.unit_cost;
    }
    private void calculate_total()
    {
        this.total = this.qty * this.unit_price;
    }
    public void set_qty(int qty)
    {
        this.qty = qty;
        this.calculate_total();
    }
    public float get_total()
    {
        return this.total;
    }
    public int get_qty()
    {
        return this.qty;
    }
    public String get_name()
    {
        return this.name;
    }


}
