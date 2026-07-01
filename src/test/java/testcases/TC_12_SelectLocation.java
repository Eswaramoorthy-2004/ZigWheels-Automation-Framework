package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.pages.UsedCarsPage;

public class TC_12_SelectLocation extends BaseTest {

    @Test
    public void selectChennaiLocation() {

        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();
        page.clickUsedCars();

        PopularModelsPage page1 = new PopularModelsPage(driver);
        page1.selectCity("Chennai");

        String selectedCity = page1.getSelectedCity();

        Assert.assertTrue(selectedCity.contains("Chennai"));

        System.out.println("Chennai location selected successfully");
    }
}