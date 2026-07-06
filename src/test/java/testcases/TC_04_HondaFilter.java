package testcases;

import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.WaitUtil;

import java.io.IOException;

public class TC_04_HondaFilter extends BaseTest {


    private static final Logger log = LoggerFactory.getLogger(TC_04_HondaFilter.class);
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
        softAssert.assertEquals(
                element.getText(),ExpectedText
        );
        softAssert.assertTrue(
                upcomingHondaBikesPage.isBikeImageDisplayed(),"Bike images are displayed"
        );
        log.info("Honda filter validated successfully");
    }
}
