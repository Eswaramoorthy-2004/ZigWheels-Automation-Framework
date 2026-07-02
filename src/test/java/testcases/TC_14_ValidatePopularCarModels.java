package testcases;

import basetest.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;

public class TC_14_ValidatePopularCarModels extends BaseTest {

    PopularModelsPage popularModelsPage;
    PropertyReader propertyReader;

    @Test
    public void validatePopularCarModels() throws IOException {

        popularModelsPage = new PopularModelsPage(driver);
        propertyReader = new PropertyReader();

        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();
        popularModelsPage.selectCity(propertyReader.getCity());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(driver -> popularModelsPage.getModelCount() > 0);

        int modelCount = popularModelsPage.getModelCount();

        Assert.assertFalse(
                driver.getTitle().isEmpty(),
                "Page title should not be empty"
        );

        Assert.assertEquals(
                popularModelsPage.getSelectedCity(),
                propertyReader.getCity(),
                "Selected city does not match expected city"
        );

        Assert.assertTrue(
                modelCount > 0,
                "No popular car models are displayed"
        );

        Assert.assertTrue(
                modelCount >= 5,
                "Less than 5 popular car models are displayed"
        );

        popularModelsPage.printModels();

        System.out.println("Page Title : " + driver.getTitle());
        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Selected City : " + popularModelsPage.getSelectedCity());
        System.out.println("Total Models Available : " + modelCount);
    }
}