package testcases;

import basetest.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.zigWheelsAutomation.pages.UsedCarsPage;

public class TC_15_ValidatePopularCarModels extends BaseTest{

    @Test
    public void validatePopularCarModels() {

        UsedCarsPage page = new UsedCarsPage(driver);

        page.clickMore();
        page.clickUsedCars();
        page.selectCity("Chennai");

        try { Thread.sleep(2000);
        } catch (Exception e) {}

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        try { Thread.sleep(2000);
        } catch (Exception e) {}

        int modelCount = page.getModelCount();

        Assert.assertTrue(modelCount > 0);

        page.printModels();

        System.out.println("Total models Available : " + modelCount);
}}
