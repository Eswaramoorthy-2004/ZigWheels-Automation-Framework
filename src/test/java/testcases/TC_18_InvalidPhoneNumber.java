package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.ScreenshotUtils;

import java.io.IOException;
import java.time.Duration;

public class TC_18_InvalidPhoneNumber extends BaseTest{
    LoginPage glp;
    PropertyReader property;
    String oldWindow;
    ScreenshotUtils ss;
    private static final Logger log = LogManager.getLogger(TC_18_InvalidPhoneNumber.class);

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        property = new PropertyReader();
        glp = new LoginPage(driver);
        ss = new ScreenshotUtils(driver);
        glp.goLogin();
        oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        glp.switchWindow();
        glp.enterEmailOrPhone(property.getValidPhoneNumber());
        glp.clickNext();
        Assert.assertEquals(
                glp.getErrorMessage(), property.getExpectedMsgInvalidPhone()
        );
        ss.screenShot("InvalidPhoneNumber");
        driver.switchTo().window(oldWindow);
        log.info("Invalid phone number");
    }
}
