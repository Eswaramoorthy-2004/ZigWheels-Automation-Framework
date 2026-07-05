package testcases;

import basetest.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigWheelsAutomation.pages.PopularModelsPage;
import org.zigWheelsAutomation.utilities.PropertyReader;
import org.zigWheelsAutomation.utilities.WaitUtil;
import java.io.IOException;


public class TC_13_ExtractPopularCarModels extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TC_13_ExtractPopularCarModels.class);
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
        log.info("Popular car models extracted successfully");
    }
}