package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UpcomingHondaBikesPage;

public class TC_05_ValidateCarCard extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_05_ValidateCarCard.class);
    UpcomingHondaBikesPage upcomingHondaBikesPage;
    SoftAssert softAssert;
    @Test
    public void testCarCard(){
        upcomingHondaBikesPage = new UpcomingHondaBikesPage(driver);
        upcomingHondaBikesPage.hoverNewBikes();
        upcomingHondaBikesPage.clickUpcomingBikes();
        upcomingHondaBikesPage.clickHondaButton();
        softAssert = new SoftAssert();
        log.info("Bike Images are Displayed");
        softAssert.assertTrue(
                upcomingHondaBikesPage.isBikeImageDisplayed(),"Bike images are displayed"
        );
        log.info("Bike Names are Displayed");
        softAssert.assertTrue(
                upcomingHondaBikesPage.isBikeNameVisible(), "Bike Name are visible"
        );
        log.info("Bike Price are Displayed");
        softAssert.assertTrue(
                upcomingHondaBikesPage.isBikePriceVisible(),"Bike Price are visible"
        );
    }

}
