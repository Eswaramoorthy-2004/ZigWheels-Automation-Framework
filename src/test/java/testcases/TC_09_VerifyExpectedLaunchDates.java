package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;

import java.util.List;

public class TC_09_VerifyExpectedLaunchDates extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_09_VerifyExpectedLaunchDates.class);
    UpcomingHondaBikesPage upcomingHondaBikesPage;
    SoftAssert softAssert;

    @Test
    public void testExpectedLaunchDates() {
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        softAssert = new SoftAssert();
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();

        List<String> launchDates = upcomingHondaBikesPage.getExpectedLaunchDates();

        softAssert.assertNotNull(
                launchDates, "Launch dates list should not be null"
        );
        softAssert.assertFalse(
                launchDates.isEmpty(), "Launch dates list should not be empty"
        );
        softAssert.assertTrue(
                launchDates.size() > 0, "At least one launch date should be captured"
        );

        softAssert.assertAll();
        log.info("Expected Launch Dates Verified Successfully");
    }
}
