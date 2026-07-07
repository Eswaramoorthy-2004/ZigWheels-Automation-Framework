package testcases;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.WaitUtil;

import java.io.IOException;

public class TC_04_HondaFilter extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_04_HondaFilter.class);
    UpcomingHondaBikesPage upcomingHondaBikesPage;
    SoftAssert softAssert;
    PropertyReader propertyReader;
    WaitUtil waitUtil;

    @Test
    public void testHondaFilter() throws IOException {
        propertyReader = new PropertyReader();
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        softAssert = new SoftAssert();
        waitUtil = new WaitUtil(driver);
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();
        String ExpectedText = propertyReader.getHondaBikeTitle();
        WebElement element = waitUtil.waitForVisibility(upcomingHondaBikesPage.getHondaPageText());
        log.info("Checking that the Honda filter is applied or not using the text of the page");
        softAssert.assertEquals(
                element.getText(),ExpectedText
        );
        log.info("Checking that the every bikes card name starts with Honda");
        softAssert.assertTrue(
                upcomingHondaBikesPage.checkHondaBikesAreDisplayed(),"Honda bikes are displayed"
        );
        log.info("Honda filter validated successfully");
    }
}
