package testcases;

import basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;

public class TC_12_SelectLocation extends BaseTest {

    PropertyReader propertyReader;
    PopularModelsPage popularModelsPage;
    int modelCount;

    @Test
    public void testSelectedLocation() throws IOException {

        popularModelsPage = new PopularModelsPage(driver);
        propertyReader = new PropertyReader();

        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();

        String expectedCity = propertyReader.getCity();

        popularModelsPage.selectCity(expectedCity);

        String selectedCity = popularModelsPage.getSelectedCity();

        System.out.println("Expected City : " + expectedCity);
        System.out.println("Selected City : " + selectedCity);

        Assert.assertEquals(
                selectedCity,
                expectedCity,
                "Selected city does not match expected city"
        );
        Assert.assertFalse(
                selectedCity.isEmpty(),
                "City field is empty"
        );
        modelCount = popularModelsPage.getModelCount();
        Assert.assertTrue(
                modelCount > 0,
                "No popular car models found for selected city"
        );
        System.out.println("Total Models Available : " + modelCount);
        System.out.println(expectedCity + " location selected successfully");
    }
}