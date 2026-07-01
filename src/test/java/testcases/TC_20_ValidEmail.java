package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import java.time.Duration;

public class TC_20_ValidEmail extends BaseTest {
    LoginPage glp;
    String emailPageTitle;
    String oldWindow;

    @Test
    public void invalidEmail() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glp = new LoginPage(driver);
        glp.goLogin();
        oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        glp.switchWindow();
        emailPageTitle=glp.pageTitle.getText();
        glp.enterEmailOrPhone("9010");
        glp.clickNext();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(glp.pageTitle,emailPageTitle)));
        Assert.assertNotEquals(emailPageTitle,glp.pageTitle.getText(),"Password field should be displayed after entering valid email");
        driver.switchTo().window(oldWindow);
    }
}
