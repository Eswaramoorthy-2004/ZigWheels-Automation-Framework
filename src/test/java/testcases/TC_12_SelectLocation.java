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


        UsedCarsPage usedCarsPage = new UsedCarsPage(driver);
        usedCarsPage.clickMore();
        usedCarsPage.clickUsedCars();

        PropertyReader propertyReader = new PropertyReader();
        String expectedCity = propertyReader.getCity();

        PopularModelsPage popularModelsPage = new PopularModelsPage(driver);
        popularModelsPage.selectCity(expectedCity);
        String selectedCity = popularModelsPage.getSelectedCity();
        System.out.println("Expected City : " + expectedCity);
        System.out.println("Selected City : " + selectedCity);

        Assert.assertTrue(
                selectedCity.contains(expectedCity),
                "City selection verified"
        );
        System.out.println(expectedCity + " location selected successfully");

    }
}