package SuperMarketPoints;

import java.util.List;

public class PromotionRuleLessThan1000 extends PointsRule {

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
       return calculateTotalAmount(purchasedGoodsList) <= 1000 && !hasCommon(purchasedGoodsList);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) * 2;
    }
}
