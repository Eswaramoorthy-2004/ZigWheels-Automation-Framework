package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;
import org.zigWheelsAutomation.utilities.ExcelUtils;

import java.util.List;

public class TC_10_StoreBikeDetails extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_10_StoreBikeDetails.class);
    UpcomingHondaBikesPage upcomingHondaBikesPage;
    SoftAssert softAssert;

    @Test
    public void testStoreBikeDetails() {
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        softAssert = new SoftAssert();

        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();

        List<String> names = upcomingHondaBikesPage.getBikeNames();
        List<String> prices = upcomingHondaBikesPage.getBikePrices();
        List<String> launchDates = upcomingHondaBikesPage.getExpectedLaunchDates();

        String excelPath = "test-output/BikeDetails.xlsx";
        ExcelUtils.writeBikeDetails(excelPath, "UpcomingHondaBikes", names, prices, launchDates);

        softAssert.assertFalse(names.isEmpty(), "Bike names list should not be empty");
        softAssert.assertFalse(prices.isEmpty(), "Prices list should not be empty");
        softAssert.assertFalse(launchDates.isEmpty(), "Launch dates list should not be empty");

        softAssert.assertAll();
        log.info("Bike Details Stored Successfully to {}", excelPath);
    }
}