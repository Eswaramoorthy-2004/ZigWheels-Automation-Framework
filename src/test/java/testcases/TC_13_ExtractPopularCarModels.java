package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;

public class TC_13_ExtractPopularCarModels extends BaseTest {

    PopularModelsPage popularModelsPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;

    @Test
    public void extractPopularCarModels() throws IOException {

        propertyReader = new PropertyReader();
        popularModelsPage = new PopularModelsPage(driver);
        softAssert = new SoftAssert();
        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();
        popularModelsPage.selectCity(propertyReader.getCity());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> popularModelsPage.getModelCount() > 0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        boolean expectedStatus = propertyReader.getBrandAndModelStatus();
        boolean actualStatus = popularModelsPage.isBrandAndModelExpanded();
        softAssert.assertEquals(
                actualStatus,
                expectedStatus,
                "Brand and Model section is not expanded"
        );
        softAssert.assertTrue(
                popularModelsPage.isPopularModelsDisplayed(),
                "Popular Models section is not displayed"
        );
        softAssert.assertAll();
        //System.out.println("Popular car models extracted successfully");
    }
}