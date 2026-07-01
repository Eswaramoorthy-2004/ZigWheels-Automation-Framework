package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UsedCarsPage;

public class TC_12_NavigateUsedcars extends BaseTest {
    @Test
    public void clickUsedCarsSection() {

        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();
        page.clickUsedCars();

        System.out.println("Used Cars section opened successfully");
}}
