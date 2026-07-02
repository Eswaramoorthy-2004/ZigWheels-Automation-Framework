package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_03_HondaFilter extends BaseTest {

    UpcomingHondaBikesPage upcomingHondaBikesPage;
    PropertyReader propertyReader;

    @Test
    public void testHondaFilter() throws IOException {
        propertyReader = new PropertyReader();
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();
        String expectedUrl = propertyReader.getHondaBikesURL();
        Assert.assertEquals(
                driver.getCurrentUrl(),expectedUrl
        );
        String expectedTitle = propertyReader.getUpcomingHondaPageTitle();
        Assert.assertEquals(
                driver.getTitle(),expectedTitle
        );
    }
}
