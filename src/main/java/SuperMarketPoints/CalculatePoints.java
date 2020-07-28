package SuperMarketPoints;

import java.util.Arrays;
import java.util.List;

public class CalculatePoints {
    private List<PurchasedGoods> purchasedGoodsList;

    private List<GoodsType> promotionList = Arrays.asList(GoodsType.APPLE, GoodsType.LAUNDRY, GoodsType.WATERMELON);

    public Boolean isPromotion(GoodsType goodsType){
        return promotionList.contains(goodsType);
    }

    public int calculateTotalPoints(List<PurchasedGoods> purchasedGoodsList){
        int totalPoints = 0;
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if (isPromotion(purchasedGoodsItem.goodsType)){
                totalPoints = purchasedGoodsItem.calculateSubTotalAmount() * 2;
                continue;
            }
            totalPoints += purchasedGoodsItem.calculateSubTotalAmount();
        }
        return totalPoints;
    }
}
