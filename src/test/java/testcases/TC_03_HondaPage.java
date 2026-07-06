package testcases;

import basetest.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_03_HondaPage extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_03_HondaPage.class);
    UpcomingHondaBikesPage upcomingHondaBikesPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;

    @Test
    public void testHondaPage() throws IOException {
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
        log.info("Honda filter applied successfully");
    }
}
