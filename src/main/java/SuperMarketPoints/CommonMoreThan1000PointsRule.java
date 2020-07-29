package SuperMarketPoints;

import java.util.List;

public class CommonMoreThan1000PointsRule extends PointsRule {

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) > ConstantsUtil.CHANGE_RULE_POINT && !hasPromotion(purchasedGoodsList);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return ConstantsUtil.CHANGE_RULE_POINT + (calculateTotalAmount(purchasedGoodsList) - ConstantsUtil.CHANGE_RULE_POINT) / ConstantsUtil.COMMON_MORE_CHANGE_RULE_POINT;
    }
}
