package SuperMarketPoints;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTest {
//    @Test
//    public void should_return_total_points_when_given_common_Goods(){
//        PurchasedGoods purchasedGoods1 = new PurchasedGoods(10, 2, GoodsType.APPLE);
//        PurchasedGoods purchasedGoods2 = new PurchasedGoods(10, 3, GoodsType.TOWEL);
//
//        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
//        purchasedGoodsList.add(purchasedGoods1);
//        purchasedGoodsList.add(purchasedGoods2);
//
//        CalculatePoints calculatePoints = new CalculatePoints();
//        int totalPoints = calculatePoints.calculateTotalPoints(purchasedGoodsList);
//
//        assertEquals(totalPoints, 70);
//    }

    @Test
    public void should_return_total_points_when_given_common_Goods_less_than_1000(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(10, 2, GoodsType.BOOK);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(10, 3, GoodsType.TOWEL);
        PurchasedGoods purchasedGoods3 = new PurchasedGoods(300, 1, GoodsType.BASKETBALL);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);
        purchasedGoodsList.add(purchasedGoods3);

        CommonBasicPointsRule calculatePoints = new CommonBasicPointsRule();
        int totalPoints = calculatePoints.getCurrentRuleTotalPoints(purchasedGoodsList);

        assertEquals(totalPoints, 350);
    }

    @Test
    public void should_return_total_points_when_given_promotion_less_than_1000(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(100, 1, GoodsType.APPLE);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(100, 2, GoodsType.LAUNDRY);
        PurchasedGoods purchasedGoods3 = new PurchasedGoods(10, 10, GoodsType.WATERMELON);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);
        purchasedGoodsList.add(purchasedGoods3);

        PromotionRuleLessThan1000 calculatePoints = new PromotionRuleLessThan1000();
        int totalPoints = calculatePoints.getCurrentRuleTotalPoints(purchasedGoodsList);

        assertEquals(totalPoints, 800);
    }
}
