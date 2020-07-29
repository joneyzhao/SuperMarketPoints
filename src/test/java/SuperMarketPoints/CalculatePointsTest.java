package SuperMarketPoints;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTest {
    private List<PointsRule> pointsRulesList = Arrays.asList(new CommonBasicPointsRule(), new CommonMoreThan1000PointsRule(), new PromotionRuleLessThan1000(), new PromotionRuleMoreThan1000(), new MixPromotionAndCommonPointsRule());

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

    @Test
    public void should_return_total_points_when_given_common_more_than_1000(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(200, 5, GoodsType.BASKETBALL);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(100, 2, GoodsType.BOOK);
        PurchasedGoods purchasedGoods3 = new PurchasedGoods(10, 10, GoodsType.TOWEL);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);
        purchasedGoodsList.add(purchasedGoods3);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.getTotalPoints(purchasedGoodsList, pointsRulesList);

        assertEquals(totalPoints, 1015);
    }

    @Test
    public void should_return_total_points_when_given_common_TV_2350(){
        PurchasedGoods purchasedGoods = new PurchasedGoods(2350, 1, GoodsType.TV);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.getTotalPoints(purchasedGoodsList, pointsRulesList);

        assertEquals(totalPoints, 1067);
    }

    @Test
    public void should_return_total_points_when_given_promotion_ICEBOX_2000(){
        PurchasedGoods purchasedGoods = new PurchasedGoods(2000, 1, GoodsType.ICEBOX);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.getTotalPoints(purchasedGoodsList, pointsRulesList);

        assertEquals(totalPoints, 3000);
    }

    @Test
    public void should_return_total_points_when_given_promotion_more_than_1000(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(800, 1, GoodsType.ICEBOX);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(100, 2, GoodsType.LAUNDRY);
        PurchasedGoods purchasedGoods3 = new PurchasedGoods(10, 10, GoodsType.APPLE);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);
        purchasedGoodsList.add(purchasedGoods3);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.getTotalPoints(purchasedGoodsList, pointsRulesList);

        assertEquals(totalPoints, 2100);
    }

    @Test
    public void should_return_total_points_when_given_common_and_promotion_more_than_1000(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(800, 1, GoodsType.ICEBOX);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(2000, 1, GoodsType.TV);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.getTotalPoints(purchasedGoodsList, pointsRulesList);

        assertEquals(totalPoints, 1890);
    }

    @Test
    public void should_return_total_points_when_given_common_and_promotion_and_promotion_more_than_1000(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(1200, 1, GoodsType.ICEBOX);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(1000, 1, GoodsType.TV);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.getTotalPoints(purchasedGoodsList, pointsRulesList);

        assertEquals(totalPoints, 2250);
    }

}
