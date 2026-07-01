package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;
import java.time.Duration;

public class TC_18_InvalidPhoneNumber extends BaseTest{
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
        glp.enterEmailOrPhone("123456@7890");
        glp.clickNext();
        Assert.assertEquals(glp.getErrorMessage(),"Enter a valid email or phone number");
        driver.switchTo().window(oldWindow);
    }

}
