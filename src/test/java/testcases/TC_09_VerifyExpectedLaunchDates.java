package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;

import java.time.LocalDate;
import java.util.List;

public class TC_09_VerifyExpectedLaunchDates extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_09_VerifyExpectedLaunchDates.class);

    UpcomingBikesPage upcomingBikesPage;
    SoftAssert softAssert;

    @Test
    public void testExpectedLaunchDates() {
        upcomingBikesPage = new UpcomingBikesPage(driver);
        softAssert = new SoftAssert();

        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();

        List<String> launchDates = upcomingBikesPage.getExpectedLaunchDates();

        softAssert.assertNotNull(
                launchDates, "Launch dates list should not be null"
        );
        softAssert.assertFalse(
                launchDates.isEmpty(), "Launch dates list should not be empty"
        );
        softAssert.assertTrue(
                launchDates.size() > 0, "At least one launch date should be captured"
        );

        LocalDate today = LocalDate.now();

        for (String rawDate : launchDates) {
            softAssert.assertTrue(
                    rawDate.toLowerCase().startsWith("expected launch"),
                    "Invalid launch date format found: " + rawDate
            );

            LocalDate parsed = upcomingBikesPage.parseLaunchDate(rawDate);
            softAssert.assertNotNull(
                    parsed, "Failed to parse launch date: " + rawDate
            );

            if (parsed != null) {
                softAssert.assertFalse(
                        parsed.isBefore(today),
                        "Launch date " + parsed + " is in the past for: " + rawDate
                );
            }
        }

        softAssert.assertAll();
        log.info("Expected Launch Dates Verified Successfully");
    }
}
