package SuperMarketPoints;

import java.util.List;

public class PromotionRuleMoreThan1000 extends PointsRule{

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) > 1000 && !hasCommon(purchasedGoodsList);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return 2000 + calculateTotalAmount(purchasedGoodsList) -1000;
    }
}
