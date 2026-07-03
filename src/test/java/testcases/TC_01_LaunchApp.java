package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.HomePage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_01_LaunchApp extends BaseTest {

    PropertyReader propertyReader;
    HomePage homePage;

    @Test
    public void verifyAppLaunch() throws IOException {
        homePage = new HomePage(driver);
        propertyReader = new PropertyReader();
        String expectedTitle = propertyReader.getPageTitle();
        Assert.assertEquals(
                driver.getTitle(), expectedTitle
        );
        String expectedURL = propertyReader.getPageURL();
        Assert.assertEquals(
                driver.getCurrentUrl(),expectedURL,"The Application Launched Successfully"
        );

        Assert.assertTrue(
                homePage.checkLogoIsDisplayed(),"Logo is displayed"
        );
    }

}
