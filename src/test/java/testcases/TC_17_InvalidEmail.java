package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import java.io.IOException;
import java.time.Duration;

public class TC_17_InvalidEmail extends BaseTest {
    LoginPage glp;
    PropertyReader property;

    @Test
    public void invalidEmail() throws InterruptedException, IOException {
        property = new PropertyReader();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        glp = new LoginPage(driver);
        glp.goLogin();
        String oldWindow = driver.getWindowHandle();
        glp.clickGoogle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        glp.switchWindow();
        glp.enterEmailOrPhone(property.getInValidEmail());
        glp.clickNext();
        Assert.assertEquals(glp.getErrorMessage(),"Enter a valid email or phone number");
        driver.switchTo().window(oldWindow);
    }
}
