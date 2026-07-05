package testcases;

import basetest.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.HomePage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_02_NavigateToUpcomingBikes extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_02_NavigateToUpcomingBikes.class);
    PropertyReader propertyReader;
    HomePage homePage;
    SoftAssert softAssert;

    @Test
    public void testUpcomingBikesPage() throws IOException {
        propertyReader = new PropertyReader();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        homePage.hoverNewBikes();
        homePage.clickUpcomingBikes();
        String expectedURL = propertyReader.getUpcomingBikesURL();
        softAssert.assertEquals(
                driver.getCurrentUrl(),expectedURL
        );
        String expectedTitle = propertyReader.getUpcomingBikesPageTitle();
        softAssert.assertEquals(
                driver.getTitle(),expectedTitle
        );
        softAssert.assertAll();
        log.info("Navigated to the upcoming page successfully");
    }
}
