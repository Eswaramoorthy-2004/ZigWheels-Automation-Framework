package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UsedCarsPage;

public class TC_14_ExtractPopularCarModels extends BaseTest {

    @Test
    public void extractPopularCarModels() {
        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();
        page.clickUsedCars();
        page.selectCity("Chennai");

        try { Thread.sleep(3000);
        } catch (Exception e) {}

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        try { Thread.sleep(2000);
        } catch (Exception e) {}

        page.printModels();

        System.out.println("Popular car models extracted successfully");
    }
}
