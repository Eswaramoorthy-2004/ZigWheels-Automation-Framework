package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;
import java.time.Duration;
import java.util.List;

public class TC_07_ExtractBikePrices extends BaseTest {
    UpcomingBikesPage upcomingBikesPage;

    @Test
    public void testBikePrices(){
        upcomingBikesPage = new UpcomingBikesPage(driver);
        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        List<String> prices = upcomingBikesPage.getBikePrices();
        Assert.assertNotNull(
                prices, "Bike prices list should not be null"
        );
        Assert.assertFalse(
                prices.isEmpty(), "Bike prices list should not be empty"
        );
        for (String price : prices) {
            Assert.assertTrue(
                    price.toLowerCase().startsWith("rs"),
                    "Invalid price format found: " + price
            );
        }
    }
}
