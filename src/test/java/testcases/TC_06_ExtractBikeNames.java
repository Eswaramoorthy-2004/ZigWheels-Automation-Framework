package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;

import java.time.Duration;
import java.util.List;

public class TC_06_ExtractBikeNames extends BaseTest {
    UpcomingBikesPage upcomingBikesPage;

    @Test
    public void testBikeName(){
        upcomingBikesPage = new UpcomingBikesPage(driver);
        upcomingBikesPage.hoverNewBikes();
        upcomingBikesPage.clickUpcomingBikes();
        upcomingBikesPage.clickHondaButton();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        List<String> names = upcomingBikesPage.getBikeNames();

        //names.forEach(System.out::println);
        //System.out.println("Total bikes captured: " + names.size());

        Assert.assertNotNull(names, "Bike names list should not be null");
        Assert.assertFalse(names.isEmpty(), "Bike names list should not be empty");
        Assert.assertTrue(names.size() > 0, "At least one bike name should be captured");
    }
}
