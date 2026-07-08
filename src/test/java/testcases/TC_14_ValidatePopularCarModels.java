package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.WaitUtil;

import java.io.IOException;

public class TC_14_ValidatePopularCarModels extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_14_ValidatePopularCarModels.class);
    PopularModelsPage popularModelsPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;
    WaitUtil wait;

    @Test
    public void validatePopularCarModels() throws IOException {
        popularModelsPage = new PopularModelsPage(driver);
        propertyReader = new PropertyReader();
        softAssert = new SoftAssert();
        wait = new WaitUtil(driver);
        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();
        popularModelsPage.selectCity(propertyReader.getCity());
        int modelCount = popularModelsPage.getModelCount();
        softAssert.assertTrue(
                modelCount > 0,
                "No popular car models are displayed"
        );
        softAssert.assertAll();
        log.info("Selected City : {}",popularModelsPage.getSelectedCity());
        log.info("Total Models Available : {}",modelCount);
    }
}