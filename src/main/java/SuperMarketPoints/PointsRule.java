package SuperMarketPoints;

import java.util.List;

public abstract class PointsRule {
    public abstract Boolean isInScope(List<PurchasedGoods> purchasedGoodsList);
    public abstract int getCurrentRuleTotalPoints(List<PurchasedGoods> purchasedGoodsList);

    public int getPoints(List<PurchasedGoods> purchasedGoodsList){
        if(isInScope(purchasedGoodsList)){
            return getCurrentRuleTotalPoints(purchasedGoodsList);
        }
        return 0;
    }

}
