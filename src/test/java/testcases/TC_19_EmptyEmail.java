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

public class TC_19_EmptyEmail extends BaseTest {
    private static final Logger log = LogManager.getLogger(TC_19_EmptyEmail.class);
    LoginPage glp;
    PropertyReader prop;
    String oldWindow;
    ScreenshotUtils ss;

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        glp = new LoginPage(driver);
        prop = new PropertyReader();
        ss = new ScreenshotUtils(driver);
        glp.goLogin();
        oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        glp.switchWindow();
        glp.enterEmailOrPhone("");
        glp.clickNext();
        Assert.assertEquals(
                glp.getErrorMessage(), prop.getExpectedMsgEmptyEmail()
        );
        ss.screenShot("EmptyEmail");
        driver.switchTo().window(oldWindow);
        log.info("Empty Email is not accepted");
        log.info("Screenshot captured successfully: EmptyEmail.png");
    }
}
