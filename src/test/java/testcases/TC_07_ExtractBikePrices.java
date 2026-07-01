package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;

import java.util.List;

public class TC_07_ExtractBikePrices{
    UpcomingBikesPage upcomingBikesPage;
    @Test
    public void testBikePrices(){
        List<String> prices = upcomingBikesPage.getBikePrices();

        //System.out.println("=========== BIKE PRICES ===========");
        prices.forEach(System.out::println);
        System.out.println("Total prices captured: " + prices.size());

        Assert.assertNotNull(prices, "Bike prices list should not be null");
        Assert.assertFalse(prices.isEmpty(), "Bike prices list should not be empty");

        // every captured price should follow the 'Rs. X Lakh' format
        for (String price : prices) {
            Assert.assertTrue(
                    price.toLowerCase().startsWith("rs"),
                    "Invalid price format found: " + price
            );
        }
    }
}
