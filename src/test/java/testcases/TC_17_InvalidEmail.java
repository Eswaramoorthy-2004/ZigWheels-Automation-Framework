package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.ScreenshotUtils;
import java.io.IOException;

public class TC_17_InvalidEmail extends BaseTest {
    private static final Logger log = LogManager.getLogger(TC_17_InvalidEmail.class);
    LoginPage glp;
    PropertyReader property;
    String oldWindow;
    ScreenshotUtils ss;

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        property = new PropertyReader();
        glp = new LoginPage(driver);
        ss = new ScreenshotUtils(driver);
        glp.goLogin();
        oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        glp.switchWindow();
        glp.enterEmailOrPhone(property.getInValidEmail());
        glp.clickNext();
        Assert.assertEquals(
                glp.getErrorMessage(),"Enter a valid email or phone number"
        );
        ss.screenShot("InvalidEmail");
        driver.switchTo().window(oldWindow);
        log.info("Invalid Email is not accepted");
    }
}
