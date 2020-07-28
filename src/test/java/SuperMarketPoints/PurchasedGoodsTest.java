package SuperMarketPoints;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchasedGoodsTest {
    @Test
    public void should_return_SubTotalAmount_when_calculate(){
        PurchasedGoods purchasedGoods = new PurchasedGoods(10, 3);

        int totalAmount = purchasedGoods.calculateSubTotalAmount();

        assertEquals(totalAmount, 30);
    }
}
