package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.HomePage;

public class TC_02_NavigateToUpcomingBikes extends BaseTest {
    HomePage homePage;
    @Test
    public void testUpcomingBikesPage(){
        homePage = new HomePage(driver);
        homePage.hoverNewBikes();
        homePage.clickUpcomingCars();

        String expectedURL = "https://www.zigwheels.com/upcoming-bikes";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
}
