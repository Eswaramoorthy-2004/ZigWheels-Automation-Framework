package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.pages.UsedCarsPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;



public class TC_14_ValidatePopularCarModels extends BaseTest {

    @Test
    public void validatePopularCarModels() {

        UsedCarsPage page = new UsedCarsPage(driver);

        page.clickMore();
        page.clickUsedCars();
        PopularModelsPage page1 = new PopularModelsPage(driver);
        page1.selectCity("Chennai");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> page1.getModelCount() > 0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        wait.until(driver -> page1.getModelCount() > 0);

        int modelCount = page1.getModelCount();

        assertTrue(modelCount > 0);

        page1.printModels();

        System.out.println("Total models Available : " + modelCount);
    }
}


