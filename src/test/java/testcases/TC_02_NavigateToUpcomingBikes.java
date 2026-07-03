package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.HomePage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_02_NavigateToUpcomingBikes extends BaseTest {

    PropertyReader propertyReader;
    HomePage homePage;

    @Test
    public void testUpcomingBikesPage() throws IOException {
        propertyReader = new PropertyReader();
        homePage = new HomePage(driver);
        homePage.hoverNewBikes();
        homePage.clickUpcomingBikes();
        String expectedURL = propertyReader.getUpcomingBikesURL();
        Assert.assertEquals(
                driver.getCurrentUrl(),expectedURL
        );
        String expectedTitle = propertyReader.getUpcomingBikesPageTitle();
        Assert.assertEquals(
                driver.getTitle(),expectedTitle
        );
    }
}
