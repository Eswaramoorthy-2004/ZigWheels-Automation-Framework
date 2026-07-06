package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;

import java.util.List;

public class TC_07_ExtractBikePrices extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_07_ExtractBikePrices.class);

    UpcomingHondaBikesPage upcomingHondaBikesPage;
    SoftAssert softAssert;

    @Test
    public void testBikePrices(){
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        softAssert = new SoftAssert();
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();
        List<String> prices = upcomingHondaBikesPage.getBikePrices();
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
        log.info("Bike price filter is working");
    }
}
