public class Customer {
    private float basic_discount;
    private float bulk_discount_10k;
    private float bulk_discount_30k;



    public Customer(float basic_discount, float bulk_discount_10k,  float bulk_discount_30k)
    {
        this.basic_discount = basic_discount;
        this.bulk_discount_10k = bulk_discount_10k;
        this.bulk_discount_30k = bulk_discount_30k;
    }

    public float get_basic_discount(){
        return this.basic_discount;
    }

    public float get_bulk_discount(float EUR)
    {
        if (EUR >= 30000)
        {
            return this.bulk_discount_30k;
        }
         if (EUR >= 10000)
        {
            return this.bulk_discount_10k;
        }
         return 0;

    }


}
