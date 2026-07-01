package testcases;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;



public class TC_14_ValidatePopularCarModels extends BaseTest {

    @Test
    public void validatePopularCarModels() throws IOException {

        UsedCarsPage page = new UsedCarsPage(driver);

        page.clickMore();
        page.clickUsedCars();
        PopularModelsPage page1 = new PopularModelsPage(driver);
        PropertyReader p1 = new PropertyReader();
        page1.selectCity(p1.getCity());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(driver -> page1.getModelCount() > 0);

        wait.until(driver -> page1.getModelCount() > 0);

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,500)");

        int modelCount = page1.getModelCount();

        assertTrue(modelCount > 0);

        page1.printModels();

        System.out.println("Total models Available : " + modelCount);
    }
}


