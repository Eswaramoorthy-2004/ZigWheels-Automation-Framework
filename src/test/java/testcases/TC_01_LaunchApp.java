package testcases;

import basetest.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.HomePage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_01_LaunchApp extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_01_LaunchApp.class);
    PropertyReader propertyReader;
    HomePage homePage;
    SoftAssert softAssert;

    @Test
    public void verifyAppLaunch() throws IOException {
        homePage = new HomePage(driver);
        propertyReader = new PropertyReader();
        softAssert = new SoftAssert();
        String expectedTitle = propertyReader.getPageTitle();
        softAssert.assertEquals(
                driver.getTitle(), expectedTitle
        );
        String expectedURL = propertyReader.getPageURL();
        softAssert.assertEquals(
                driver.getCurrentUrl(),expectedURL,"The Application Launched Successfully"
        );
        softAssert.assertTrue(
                homePage.checkLogoIsDisplayed(),"Logo is displayed"
        );
        softAssert.assertAll();
        log.info("Application launched successfully");
        log.info("I'm done");
    }

}
