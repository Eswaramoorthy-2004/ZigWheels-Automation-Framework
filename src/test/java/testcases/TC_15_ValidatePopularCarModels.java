package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.UsedCarsPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class TC_15_ValidatePopularCarModels extends BaseTest {

    @Test
    public void validatePopularCarModels() {

        UsedCarsPage page = new UsedCarsPage(driver);

        page.clickMore();
        page.clickUsedCars();
        page.selectCity("Chennai");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> page.getModelCount() > 0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        wait.until(driver -> page.getModelCount() > 0);

        int modelCount = page.getModelCount();

        assertTrue(modelCount > 0);

        page.printModels();

        System.out.println("Total models Available : " + modelCount);
    }
}
