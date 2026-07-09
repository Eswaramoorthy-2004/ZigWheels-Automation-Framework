package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.ScreenshotUtils;

import java.io.IOException;

public class TC_11_NavigateUsedcars extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_11_NavigateUsedcars.class);
    UsedCarsPage usedCarsPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;
    ScreenshotUtils ss;

    @Test
    public void testUsedCarsSection() throws IOException {
        usedCarsPage = new UsedCarsPage(driver);
        propertyReader = new PropertyReader();
        softAssert = new SoftAssert();
        ss = new ScreenshotUtils(driver);
        usedCarsPage.clickMore();
        usedCarsPage.clickUsedCars();
        String CurrentUrl = driver.getCurrentUrl();
        String expectedUrl = propertyReader.getUsedCarPageUrl();
        softAssert.assertEquals(
                CurrentUrl,expectedUrl,"The URL is Checked Successfully"
        );
        String actualTitle = driver.getTitle();
        String expectedTitle = propertyReader.getUsedCarPageTitle();
        softAssert.assertEquals(
                actualTitle, expectedTitle, "Page title validation failed"
        );
        softAssert.assertAll();
        log.info("URL: {}",CurrentUrl);
        log.info("Title: {}",actualTitle);
        ss.screenShot("UsedCars");
    }
}