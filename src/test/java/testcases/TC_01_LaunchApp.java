package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_LaunchApp extends BaseTest {
    @Test
    public void verifyAppLaunch() {
        String expectedTitle = "New Cars, Bikes & Scooters, Used Cars, News & Reviews - ZigWheels";
        Assert.assertEquals(driver.getTitle(), "New Cars, Bikes & Scooters, Used Cars, News & Reviews - ZigWheels");
    }
    //New Cars, Bikes & Scooters, Used Cars, News & Reviews - ZigWheels
}
