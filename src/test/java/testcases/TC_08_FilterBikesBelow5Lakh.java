package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class TC_08_FilterBikesBelow5Lakh extends BaseTest {

    UpcomingBikesPage upcomingBikesPage;

    @Test
    public void testFilterBikesBelow5Lakh() {
        upcomingBikesPage = new UpcomingBikesPage(driver);
        SoftAssert softAssert = new SoftAssert();
        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        double threshold = 5.0;
        List<String> belowThresholdPrices = upcomingBikesPage.getPricesBelow(threshold);
        Map<String, String> bikesBelowThreshold = upcomingBikesPage.getBikesBelow(threshold);
        softAssert.assertNotNull(
                belowThresholdPrices,
                "Filtered price list should not be null");
        softAssert.assertFalse(
                belowThresholdPrices.isEmpty(),
                "There should be at least one bike priced below Rs. 5 Lakh");
        for (String price : belowThresholdPrices) {
            double value = upcomingBikesPage.parsePriceToLakh(price);

            softAssert.assertTrue(value > 0,
                    "Price could not be parsed correctly: " + price);

            softAssert.assertTrue(value < threshold,
                    "Price " + price + " is NOT below Rs. 5 Lakh");
        }
        softAssert.assertEquals(bikesBelowThreshold.size(), belowThresholdPrices.size(),
                "Mismatch between filtered bike-price map and price list");
        softAssert.assertAll();
    }

}