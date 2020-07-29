package SuperMarketPoints;

import java.util.List;

public class CommonBasicPointsRule extends PointsRule {

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) <= ConstantsUtil.CHANGE_RULE_POINT && !hasPromotion(purchasedGoodsList);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList);
    }
}
