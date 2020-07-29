package SuperMarketPoints;

import java.util.Arrays;
import java.util.List;

public class CalculatePoints {
    private List<PurchasedGoods> purchasedGoodsList;

    private List<PointsRule> pointsRulesList;

    public int getTotalPoints(List<PurchasedGoods> purchasedGoodsList, List<PointsRule> pointsRulesList){
        int totalPoints = 0;
        for (int i = 0; i< pointsRulesList.size(); i++){
            totalPoints += pointsRulesList.get(i).getCurrentRuleTotalPoints(purchasedGoodsList);
        }
        return totalPoints;
    }



//    private List<GoodsType> promotionList = Arrays.asList(GoodsType.APPLE, GoodsType.LAUNDRY, GoodsType.WATERMELON);

//    public Boolean isPromotion(GoodsType goodsType){
//        return promotionList.contains(goodsType);
//    }

//    public int calculateTotalPoints(List<PurchasedGoods> purchasedGoodsList){
////        int totalPoints = 0;
////        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
////            if (isPromotion(purchasedGoodsItem.goodsType)){
////                totalPoints = purchasedGoodsItem.calculateSubTotalAmount() * 2;
////                continue;
////            }
////            totalPoints += purchasedGoodsItem.calculateSubTotalAmount();
////        }
////        return totalPoints;
//    }
}
