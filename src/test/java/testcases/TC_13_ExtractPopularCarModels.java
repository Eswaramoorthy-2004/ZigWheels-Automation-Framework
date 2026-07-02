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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> popularModelsPage.getModelCount() > 0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        boolean expectedStatus = propertyReader.getBrandAndModelStatus();
        boolean actualStatus = popularModelsPage.isBrandAndModelExpanded();

        Assert.assertEquals(
                actualStatus,
                expectedStatus,
                "Brand and Model section is not expanded"
        );

        Assert.assertTrue(
                popularModelsPage.isPopularModelsDisplayed(),
                "Popular Models section is not displayed"
        );

        System.out.println("Popular car models extracted successfully");
    }
}