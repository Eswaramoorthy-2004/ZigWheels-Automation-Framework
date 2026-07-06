package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.LoginPage;
import org.zigWheelsAutomation.utilities.ScreenshotUtils;

import java.io.IOException;

public class TC_16_ValidateLoginOptions extends BaseTest {
    private static final Logger log = LogManager.getLogger(TC_16_ValidateLoginOptions.class);
    LoginPage glp;
    ScreenshotUtils ss;
    SoftAssert asserts;

    @Test
    public void invalidEmail() throws IOException {
        glp = new LoginPage(driver);
        ss = new ScreenshotUtils(driver);
        asserts = new SoftAssert();
        glp.goLogin();
        asserts.assertTrue(
                glp.google.isDisplayed(),"Login with not Google is available"
        );
        asserts.assertTrue(
                glp.facebook.isDisplayed(),"Login with not Facebook is available"
        );
        asserts.assertTrue(
                glp.apple.isDisplayed(),"Login with not apple is available"
        );
        asserts.assertAll();
        ss.screenShot("LoginOptions");
        log.info("Login with Google, Facebook, Apple are available");
        log.info("Screenshot captured successfully: LoginOption.png");
    }
}
