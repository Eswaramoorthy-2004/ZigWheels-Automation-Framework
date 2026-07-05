package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;
import java.time.Duration;
import java.util.List;

public class TC_06_ExtractBikeNames extends BaseTest {

    UpcomingBikesPage upcomingBikesPage;
    SoftAssert softAssert;

    @Test
    public void testBikeName(){
        upcomingBikesPage = new UpcomingBikesPage(driver);
        softAssert = new SoftAssert();
        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
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
    }
}
