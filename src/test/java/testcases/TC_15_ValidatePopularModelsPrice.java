package testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import java.io.IOException;
import java.util.List;

public class TC_15_ValidatePopularModelsPrice extends BaseTest {

    private static final Logger log =
            LogManager.getLogger(TC_15_ValidatePopularModelsPrice.class);
    PopularModelsPage popularModelsPage;
    PropertyReader propertyReader;
    SoftAssert softAssert;

    @Test
    public void validatePopularModelsPrice() throws IOException {

        popularModelsPage = new PopularModelsPage(driver);
        propertyReader = new PropertyReader();
        softAssert = new SoftAssert();
        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();
        popularModelsPage.selectCity(propertyReader.getCity());
        List<String> prices = popularModelsPage.getAllPrices();
        softAssert.assertTrue(
                prices.size() > 0,
                "No car prices found"
        );
        for (String price : prices) {
            softAssert.assertFalse(
                    price.trim().isEmpty(),
                    "Price is missing for a car listing"
            );
            log.info("Car Price : {}", price);
        }
        softAssert.assertAll();
    }
}