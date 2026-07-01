package testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_12_SelectLocation extends BaseTest {

    @Test
    public void selectChennaiLocation() throws IOException {

        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();
        page.clickUsedCars();

        PopularModelsPage page1 = new PopularModelsPage(driver);
        PropertyReader p0 = new PropertyReader();
        page1.selectCity(p0.getCity());


        String selectedCity = page1.getSelectedCity();

        Assert.assertTrue(selectedCity.contains("Chennai"));

        System.out.println("Chennai location selected successfully");
    }
}