package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.UpcomingBikesPage;

import java.util.List;

public class TC_06_ExtractBikeNames extends BaseTest {
    UpcomingBikesPage upcomingBikesPage;
    @Test
    public void testBikeName(){
        List<String> names = upcomingBikesPage.getBikeNames();

        //System.out.println("=========== BIKE NAMES ===========");
        names.forEach(System.out::println);
        System.out.println("Total bikes captured: " + names.size());

        Assert.assertNotNull(names, "Bike names list should not be null");
        Assert.assertFalse(names.isEmpty(), "Bike names list should not be empty");
        Assert.assertTrue(names.size() > 0, "At least one bike name should be captured");
    }
}
