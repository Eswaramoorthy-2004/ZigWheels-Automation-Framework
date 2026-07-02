package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.pages.UsedCarsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class TC_13_ExtractPopularCarModels extends BaseTest {

    @Test
    public void extractPopularCarModels() throws IOException {

        UsedCarsPage page = new UsedCarsPage(driver);
        PropertyReader p =new PropertyReader();

        page.clickMore();
        page.clickUsedCars();
        PopularModelsPage page1 = new PopularModelsPage(driver);
        page1.selectCity(p.getCity());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> page1.getModelCount() > 0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        int modelCount = page1.getModelCount();
        assertTrue(modelCount > 0);

        page1.printModels();
        System.out.println("Popular car models extracted successfully");
    }
}


