package SuperMarketPoints;

import java.util.Arrays;
import java.util.List;

public abstract class PointsRule {
    private List<GoodsType> promotionList = Arrays.asList(GoodsType.APPLE, GoodsType.LAUNDRY, GoodsType.WATERMELON, GoodsType.ICEBOX);

    public abstract Boolean isInScope(List<PurchasedGoods> purchasedGoodsList);
    public abstract int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList);

    public Boolean isPromotion(GoodsType goodsType){
        return promotionList.contains(goodsType);
    }

    public Boolean hasPromotion(List<PurchasedGoods> purchasedGoodsList){
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(isPromotion(purchasedGoodsItem.goodsType)){
                return true;
            }
        }
        return false;
    }

    public Boolean hasCommon(List<PurchasedGoods> purchasedGoodsList){
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(!isPromotion(purchasedGoodsItem.goodsType)){
                return true;
            }
        }
        return false;
    }

    public int calculateTotalAmount(List<PurchasedGoods> purchasedGoodsList){
        int totalAmount = 0;
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            totalAmount += purchasedGoodsItem.calculateSubTotalAmount();
        }
        return totalAmount;
    }

    public int getPoints(List<PurchasedGoods> purchasedGoodsList){
        if(isInScope(purchasedGoodsList)){
            return getCurrentRuleTotalPoints(purchasedGoodsList);
        }
        return 0;
    }

}
