package SuperMarketPoints;

import java.util.List;

public class CommonBasicPointsRule extends PointsRule {

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) <= 1000 && !hasPromotion(purchasedGoodsList);
    }

    @Override
    public int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList);
    }
}
