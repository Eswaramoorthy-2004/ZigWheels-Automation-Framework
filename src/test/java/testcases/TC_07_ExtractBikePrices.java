package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;
import java.util.List;

public class TC_07_ExtractBikePrices extends BaseTest {

    UpcomingBikesPage upcomingBikesPage;
    SoftAssert softAssert;

    @Test
    public void testBikePrices(){
        upcomingBikesPage = new UpcomingBikesPage(driver);
        softAssert = new SoftAssert();
        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();
        List<String> prices = upcomingBikesPage.getBikePrices();
        softAssert.assertNotNull(
                prices, "Bike prices list should not be null"
        );
        softAssert.assertFalse(
                prices.isEmpty(), "Bike prices list should not be empty"
        );
        for (String price : prices) {
            softAssert.assertTrue(
                    price.toLowerCase().startsWith("rs"),
                    "Invalid price format found: " + price
            );
        }
        softAssert.assertAll();
    }
}
