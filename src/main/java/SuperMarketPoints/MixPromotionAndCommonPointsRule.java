package SuperMarketPoints;

import java.util.ArrayList;
import java.util.List;

public class MixPromotionAndCommonPointsRule extends PointsRule{

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) > 1000 && hasCommon(purchasedGoodsList) && hasPromotion(purchasedGoodsList);
    }

    public List<PurchasedGoods> getPromotionList(List<PurchasedGoods> purchasedGoodsList){
        List<PurchasedGoods> promotionList = new ArrayList<>();
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(isPromotion(purchasedGoodsItem.goodsType)){
                promotionList.add(purchasedGoodsItem);
            }
        }
        return promotionList;
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        if (calculateTotalAmount(getPromotionList(purchasedGoodsList)) <= 1000){
            return calculateTotalAmount(getPromotionList(purchasedGoodsList)) * 2 + (1000 - calculateTotalAmount(getPromotionList(purchasedGoodsList))) + (calculateTotalAmount(purchasedGoodsList) - 1000) / 20;
        }

        return 2000 + calculateTotalAmount(getPromotionList(purchasedGoodsList)) - 1000 + (calculateTotalAmount(purchasedGoodsList) - calculateTotalAmount(getPromotionList(purchasedGoodsList))) / 20;
    }
}
