package SuperMarketPoints;

import java.util.List;

public class CalculatePoints {

    public int getTotalPoints(List<PurchasedGoods> purchasedGoodsList, List<PointsRule> pointsRulesList){
        int totalPoints = 0;
        for (int i = 0; i< pointsRulesList.size(); i++){
            totalPoints += pointsRulesList.get(i).getPoints(purchasedGoodsList);
        }
        return totalPoints;
    }

}
