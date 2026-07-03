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
        Assert.assertTrue(
                modelCount > 0,
                "No popular car models are displayed"
        );
        popularModelsPage.printModels();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(400));
        wait1.until(driver -> popularModelsPage.getModelCount() > 0);
        Assert.assertEquals(
                popularModelsPage.getUsedCarsHeaderText(),
                propertyReader.getUsedCarsHeader(),
                "Used Cars header text mismatch"
        );
        System.out.println("Selected City : " + popularModelsPage.getSelectedCity());
        System.out.println("Total Models Available : " + modelCount);
    }
}