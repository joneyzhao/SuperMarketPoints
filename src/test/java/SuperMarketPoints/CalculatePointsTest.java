package SuperMarketPoints;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatePointsTest {
    @Test
    public void should_return_total_points_when_given_commom_Goods(){
        PurchasedGoods purchasedGoods1 = new PurchasedGoods(10, 2);
        PurchasedGoods purchasedGoods2 = new PurchasedGoods(6, 3);

        List<PurchasedGoods> purchasedGoodsList = new ArrayList();
        purchasedGoodsList.add(purchasedGoods1);
        purchasedGoodsList.add(purchasedGoods2);

        CalculatePoints calculatePoints = new CalculatePoints();
        int totalPoints = calculatePoints.calculateTotalPoints(purchasedGoodsList);

        assertEquals(totalPoints, 38);

    }
}
