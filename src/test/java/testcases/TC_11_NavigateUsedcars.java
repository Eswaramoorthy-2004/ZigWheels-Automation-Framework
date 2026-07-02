package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class TC_11_NavigateUsedcars extends BaseTest {
    @Test
    public void clickUsedCarsSection() throws IOException {

        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();
        page.clickUsedCars();

        String Currenrurl = driver.getCurrentUrl();
        PropertyReader p3 = new PropertyReader();
        String expectedUrl = p3.getUsedcarpageurl();

        Assert.assertEquals(Currenrurl,expectedUrl,"The URL is Checked Successfully");
        System.out.println("Used Cars section opened successfully");
}}
