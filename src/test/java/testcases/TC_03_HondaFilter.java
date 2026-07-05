package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_03_HondaFilter extends BaseTest {

    UpcomingHondaBikesPage upcomingHondaBikesPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;

    @Test
    public void testHondaFilter() throws IOException {
        propertyReader = new PropertyReader();
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        softAssert = new SoftAssert();
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();
        String expectedUrl = propertyReader.getHondaBikesURL();
        softAssert.assertEquals(
                driver.getCurrentUrl(),expectedUrl
        );
        String expectedTitle = propertyReader.getUpcomingHondaPageTitle();
        softAssert.assertEquals(
                driver.getTitle(),expectedTitle
        );
        softAssert.assertAll();
    }
}
