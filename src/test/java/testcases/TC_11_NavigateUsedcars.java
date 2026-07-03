package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;


public class TC_11_NavigateUsedcars extends BaseTest {
    UsedCarsPage usedCarsPage;
    PropertyReader propertyReader;

    @Test
    public void testUsedCarsSection() throws IOException {
        usedCarsPage = new UsedCarsPage(driver);
        propertyReader = new PropertyReader();
        usedCarsPage.clickMore();
        usedCarsPage.clickUsedCars();
        String CurrentUrl = driver.getCurrentUrl();
        String expectedUrl = propertyReader.getUsedcarpageurl();
        Assert.assertEquals(CurrentUrl,expectedUrl,"The URL is Checked Successfully");
        String actualTitle = driver.getTitle();
        String expectedTitle = propertyReader.getUsedcarPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle,
                "Page title validation failed");

        System.out.println("URL : " + CurrentUrl);
        System.out.println("Title : " + actualTitle);
    }}