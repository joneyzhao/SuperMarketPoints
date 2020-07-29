package SuperMarketPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MixPromotionAndCommonPointsRule extends PointsRule{
    private List<GoodsType> promotionList = Arrays.asList(GoodsType.APPLE, GoodsType.LAUNDRY, GoodsType.WATERMELON, GoodsType.ICEBOX);

    @Override
    public Boolean isInScope(List<PurchasedGoods> purchasedGoodsList) {
        return calculateTotalAmount(purchasedGoodsList) > 1000 && hasCommon(purchasedGoodsList) && hasPromotion(purchasedGoodsList);
    }

    public int calculateTotalAmount(List<PurchasedGoods> purchasedGoodsList){
        int totalAmount = 0;
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            totalAmount += purchasedGoodsItem.calculateSubTotalAmount();
        }
        return totalAmount;
    }

    public Boolean isPromotion(GoodsType goodsType){
        return promotionList.contains(goodsType);
    }

    public Boolean hasCommon(List<PurchasedGoods> purchasedGoodsList){
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(!isPromotion(purchasedGoodsItem.goodsType)){
                return true;
            }
        }
        return false;
    }

    public Boolean hasPromotion(List<PurchasedGoods> purchasedGoodsList){
        for(PurchasedGoods purchasedGoodsItem : purchasedGoodsList){
            if(isPromotion(purchasedGoodsItem.goodsType)){
                return true;
            }
        }
        return false;
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
        if(isInScope(purchasedGoodsList)){
            if (calculateTotalAmount(getPromotionList(purchasedGoodsList)) <= 1000){
                return calculateTotalAmount(getPromotionList(purchasedGoodsList)) * 2 + (1000 - calculateTotalAmount(getPromotionList(purchasedGoodsList))) + (calculateTotalAmount(purchasedGoodsList) - 1000) / 20;
            }

            return 2000 + calculateTotalAmount(getPromotionList(purchasedGoodsList)) - 1000 + (calculateTotalAmount(purchasedGoodsList) - calculateTotalAmount(getPromotionList(purchasedGoodsList))) / 20;
        }
        return 0;
    }
}
