package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;

public class TC_03_HondaFilter extends BaseTest {
    UpcomingHondaBikesPage upcomingHondaBikesPage;
    @Test
    public void testHondaFilter(){
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();

        String ExpectedUrl = "https://www.zigwheels.com/upcoming-honda-bikes";
        Assert.assertEquals(driver.getCurrentUrl(),ExpectedUrl);
    }
}
