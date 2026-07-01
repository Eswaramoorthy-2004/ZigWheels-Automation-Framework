package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import java.time.Duration;

public class TC_19_EmptyEmail extends BaseTest {
    LoginPage glp;

    @Test
    public void invalidEmail() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glp = new LoginPage(driver);
        glp.goLogin();
        String oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        glp.switchWindow();
        glp.enterEmailOrPhone("");
        glp.clickNext();
        Assert.assertEquals(glp.getErrorMessage(), "Enter an email or phone number");
        driver.switchTo().window(oldWindow);
    }
}
