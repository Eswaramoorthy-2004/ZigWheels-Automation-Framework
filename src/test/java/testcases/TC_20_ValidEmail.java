package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.ScreenshotUtils;
import org.zigWheelsAutomation.utilities.WaitUtil;

import java.io.IOException;
import java.time.Duration;

public class TC_20_ValidEmail extends BaseTest {
    LoginPage glp;
    String emailPageTitle;
    String oldWindow;
    PropertyReader property;
    ScreenshotUtils ss;
    WaitUtil wait;
    boolean Wait;

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        property = new PropertyReader();
        glp = new LoginPage(driver);
        ss = new ScreenshotUtils(driver);
        wait = new WaitUtil(driver);
        glp.goLogin();
        oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        glp.switchWindow();
        emailPageTitle=glp.pageTitle.getText();
        glp.enterEmailOrPhone(property.getValidEmail());
        glp.clickNext();
        Wait = wait.waitForTextToBePresent(glp.pageTitle,emailPageTitle);
        Assert.assertNotEquals(
                emailPageTitle,
                glp.pageTitle.getText(),
                "Password field should be displayed after entering valid email"
        );
        ss.screenShot("ValidEmail");
        driver.switchTo().window(oldWindow);
    }
}
