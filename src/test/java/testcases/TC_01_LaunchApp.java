package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_01_LaunchApp extends BaseTest {
    PropertyReader propertyReader;
    @Test
    public void verifyAppLaunch() throws IOException {
        propertyReader = new PropertyReader();

        String expectedTitle = propertyReader.getPageTitle();
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        String expectedURL = propertyReader.getPageURL();
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL,"The Application Launched Successfully");
    }

}
