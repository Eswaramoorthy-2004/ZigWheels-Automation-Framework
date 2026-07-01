package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.UsedCarsPage;

public class TC_11_NavigateUsedcars extends BaseTest {
    @Test
    public void clickUsedCarsSection() {

        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();
        page.clickUsedCars();

        String Currenrurl = driver.getCurrentUrl();
        String expectedUrl = "https://www.zigwheels.com/used-car";

        Assert.assertEquals(Currenrurl,expectedUrl,"The URL is Checked Successfully");
        System.out.println("Used Cars section opened successfully");
}}
