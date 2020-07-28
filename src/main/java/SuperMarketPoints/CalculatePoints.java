package SuperMarketPoints;

import java.util.List;

public class CalculatePoints {
    private List<PurchasedGoods> purchasedGoodsList;

    public int calculateTotalPoints(List<PurchasedGoods> purchasedGoodsList){
        int totalAmount = 0;
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            totalAmount += purchasedGoodsItem.calculateSubTotalAmount();
        }
        return totalAmount;
    }
}
