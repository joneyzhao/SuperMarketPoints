package SuperMarketPoints;

public class PurchasedGoods {
    private int price;
    private int quantity;
    protected GoodsType goodsType;

    public PurchasedGoods(int price, int quantity, GoodsType goodsType){

        this.price = price;
        this.quantity = quantity;
        this.goodsType = goodsType;
    }

    public int calculateSubTotalAmount(){
        return price * quantity;
    }
}
