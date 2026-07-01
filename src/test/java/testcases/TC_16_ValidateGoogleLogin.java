package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;

public class TC_16_ValidateGoogleLogin extends BaseTest {
    LoginPage glp;

    @Test
    public void invalidEmail() {
        glp = new LoginPage(driver);
        glp.goLogin();
        //System.out.println(glp.google.isDisplayed());
        Assert.assertTrue(glp.google.isDisplayed());
    }
}
