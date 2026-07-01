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

        System.out.println("Used Cars section opened successfully");
}}
