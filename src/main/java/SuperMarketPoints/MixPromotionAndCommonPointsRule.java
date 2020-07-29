package SuperMarketPoints;

import java.util.ArrayList;
import java.util.List;

public class MixPromotionAndCommonPointsRule extends PointsRule{

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) > ConstantsUtil.CHANGE_RULE_POINT && hasCommon(purchasedGoodsList) && hasPromotion(purchasedGoodsList);
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
        if (calculateTotalAmount(getPromotionList(purchasedGoodsList)) <= ConstantsUtil.CHANGE_RULE_POINT){
            return calculateTotalAmount(getPromotionList(purchasedGoodsList)) * ConstantsUtil.PROMOTION_LESS_CHANGE_RULE_POINT + (ConstantsUtil.CHANGE_RULE_POINT - calculateTotalAmount(getPromotionList(purchasedGoodsList))) + (calculateTotalAmount(purchasedGoodsList) - ConstantsUtil.CHANGE_RULE_POINT) / ConstantsUtil.COMMON_MORE_CHANGE_RULE_POINT;
        }

        return ConstantsUtil.CHANGE_RULE_POINT * ConstantsUtil.PROMOTION_LESS_CHANGE_RULE_POINT + calculateTotalAmount(getPromotionList(purchasedGoodsList)) - ConstantsUtil.CHANGE_RULE_POINT + (calculateTotalAmount(purchasedGoodsList) - calculateTotalAmount(getPromotionList(purchasedGoodsList))) / ConstantsUtil.COMMON_MORE_CHANGE_RULE_POINT;
    }
}
