package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;


public class TC_11_NavigateUsedcars extends BaseTest {

    UsedCarsPage usedCarsPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;

    @Test
    public void testUsedCarsSection() throws IOException {
        usedCarsPage = new UsedCarsPage(driver);
        propertyReader = new PropertyReader();
        softAssert = new SoftAssert();
        usedCarsPage.clickMore();
        usedCarsPage.clickUsedCars();
        String CurrentUrl = driver.getCurrentUrl();
        String expectedUrl = propertyReader.getUsedcarpageurl();
        softAssert.assertEquals(
                CurrentUrl,expectedUrl,"The URL is Checked Successfully"
        );
        String actualTitle = driver.getTitle();
        String expectedTitle = propertyReader.getUsedcarPageTitle();
        softAssert.assertEquals(
                actualTitle, expectedTitle, "Page title validation failed"
        );
        softAssert.assertAll();
        System.out.println("URL : " + CurrentUrl);
        System.out.println("Title : " + actualTitle);
    }
}