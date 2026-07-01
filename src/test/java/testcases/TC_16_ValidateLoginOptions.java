package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.LoginPage;

public class TC_16_ValidateLoginOptions extends BaseTest {
    LoginPage glp;

    @Test
    public void invalidEmail() {
        glp = new LoginPage(driver);
        glp.goLogin();
        SoftAssert asserts = new SoftAssert();
        asserts.assertTrue(glp.google.isDisplayed(),"Login with not Google is available");
        asserts.assertTrue(glp.facebook.isDisplayed(),"Login with not Facebook is available");
        asserts.assertTrue(glp.apple.isDisplayed(),"Login with not apple is available");
        asserts.assertAll();
    }
}
