package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import org.zigWheelsAutomation.utilities.ScreenshotUtils;

import java.io.IOException;
import java.time.Duration;

public class TC_19_EmptyEmail extends BaseTest {
    LoginPage glp;
    String oldWindow;
    ScreenshotUtils ss;

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        glp = new LoginPage(driver);
        ss = new ScreenshotUtils(driver);
        glp.goLogin();
        oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        glp.switchWindow();
        glp.enterEmailOrPhone("");
        glp.clickNext();
        Assert.assertEquals(
                glp.getErrorMessage(), "Enter an email or phone number"
        );
        ss.screenShot("EmptyEmail");
        driver.switchTo().window(oldWindow);
    }
}
