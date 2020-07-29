package SuperMarketPoints;

import java.util.List;

public class PromotionRuleLessThan1000 extends PointsRule {

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
       return calculateTotalAmount(purchasedGoodsList) <= ConstantsUtil.CHANGE_RULE_POINT && !hasCommon(purchasedGoodsList);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) * ConstantsUtil.PROMOTION_LESS_CHANGE_RULE_POINT;
    }
}
