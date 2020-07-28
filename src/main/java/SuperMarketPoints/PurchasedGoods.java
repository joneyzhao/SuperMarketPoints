package SuperMarketPoints;

public class PurchasedGoods {
    private int price;
    private int quantity;

    public PurchasedGoods(int price, int quantity){

        this.price = price;
        this.quantity = quantity;
    }

    public int calculateSubTotalAmount(){
        return price * quantity;
    }
}
