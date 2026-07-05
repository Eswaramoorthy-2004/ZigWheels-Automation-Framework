package testcases;

import basetest.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import java.io.IOException;

public class TC_12_SelectLocation extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_12_SelectLocation.class);
    PropertyReader propertyReader;
    PopularModelsPage popularModelsPage;
    SoftAssert softAssert;

    @Test
    public void testSelectedLocation() throws IOException {
        popularModelsPage = new PopularModelsPage(driver);
        propertyReader = new PropertyReader();
        softAssert = new SoftAssert();
        popularModelsPage.clickMore();
        popularModelsPage.clickUsedCars();
        String expectedCity = propertyReader.getCity();
        popularModelsPage.selectCity(expectedCity);
        String selectedCity = popularModelsPage.getSelectedCity();
        System.out.println("Expected City : " + expectedCity);
        System.out.println("Selected City : " + selectedCity);
        softAssert.assertEquals(
                selectedCity,
                expectedCity,
                "Selected city does not match expected city"
        );
        softAssert.assertFalse(
                selectedCity.isEmpty(),
                "City field is empty"
        );
        softAssert.assertAll();
        log.info("{} location selected successfully",expectedCity);
    }
}