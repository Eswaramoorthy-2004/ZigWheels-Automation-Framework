package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;
import java.util.List;

public class TC_06_ExtractBikeNames extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_06_ExtractBikeNames.class);

    UpcomingBikesPage upcomingBikesPage;
    SoftAssert softAssert;

    @Test
    public void testBikeName(){
        upcomingBikesPage = new UpcomingBikesPage(driver);
        softAssert = new SoftAssert();
        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();
        List<String> names = upcomingBikesPage.getBikeNames();
        softAssert.assertNotNull(
                names, "Bike names list should not be null"
        );
        softAssert.assertFalse(
                names.isEmpty(), "Bike names list should not be empty"
        );
        softAssert.assertTrue(
                names.size() > 0, "At least one bike name should be captured"
        );
        softAssert.assertAll();
        log.info("Bike Names Extracted Succesfully");
    }
}
