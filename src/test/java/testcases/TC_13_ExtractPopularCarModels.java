package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;

public class TC_13_ExtractPopularCarModels extends BaseTest {

    PopularModelsPage popularModelsPage;
    PropertyReader propertyReader;

    @Test
    public void extractPopularCarModels() throws IOException {

        propertyReader = new PropertyReader();
        popularModelsPage = new PopularModelsPage(driver);

        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();
        popularModelsPage.selectCity(propertyReader.getCity());

        String selectedCity = popularModelsPage.getSelectedCity();

        Assert.assertEquals(
                selectedCity,
                propertyReader.getCity(),
                "Selected city is not matching the expected city"
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> popularModelsPage.getModelCount() > 0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        int modelCount = popularModelsPage.getModelCount();


        Assert.assertTrue(
                modelCount > 0,
                "Popular model count should be greater than zero"
        );
        Assert.assertFalse(
                driver.getTitle().isEmpty(),
                "Page title should not be empty"
        );


        System.out.println("Selected City : " + selectedCity);
        System.out.println("Page Title : " + driver.getTitle());
        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Popular car models extracted successfully");
    }
}