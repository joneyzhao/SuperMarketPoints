package SuperMarketPoints;

import java.util.Arrays;
import java.util.List;

public class CommonMoreThan1000PointsRule extends PointsRule {
    private List<GoodsType> promotionList = Arrays.asList(GoodsType.APPLE, GoodsType.LAUNDRY, GoodsType.WATERMELON, GoodsType.ICEBOX);

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) > 1000 && !hasPromotion(purchasedGoodsList);
    }

    public int calculateTotalAmount(List<PurchasedGoods> purchasedGoodsList){
        int totalAmount = 0;
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            totalAmount += purchasedGoodsItem.calculateSubTotalAmount();
        }
        return totalAmount;
    }

    public Boolean hasPromotion(List<PurchasedGoods> purchasedGoodsList){
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(isPromotion(purchasedGoodsItem.goodsType)){
                return true;
            }
        }
        return false;
    }

    public Boolean isPromotion(GoodsType goodsType){
        return promotionList.contains(goodsType);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        if(isInScope(purchasedGoodsList)){
            return 1000 + (calculateTotalAmount(purchasedGoodsList) - 1000) / 20;
        }
        return 0;
    }
}
