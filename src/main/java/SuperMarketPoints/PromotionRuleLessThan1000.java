package SuperMarketPoints;

import java.util.Arrays;
import java.util.List;

public class PromotionRuleLessThan1000 extends PointsRule {
    private List<GoodsType> promotionList = Arrays.asList(GoodsType.APPLE, GoodsType.LAUNDRY, GoodsType.WATERMELON, GoodsType.ICEBOX);

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
       return calculateTotalAmount(purchasedGoodsList) <= 1000 && !hasCommon(purchasedGoodsList);
    }

    public int calculateTotalAmount(List<PurchasedGoods> purchasedGoodsList){
        int totalAmount = 0;
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            totalAmount += purchasedGoodsItem.calculateSubTotalAmount();
        }
        return totalAmount;
    }

    public Boolean isPromotion(GoodsType goodsType){
        return promotionList.contains(goodsType);
    }

    public Boolean hasCommon(List<PurchasedGoods> purchasedGoodsList){
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(!isPromotion(purchasedGoodsItem.goodsType)){
                return true;
            }
        }
        return false;
    }
    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) * 2;
    }
}
