package org.zigWheelsAutomation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    WebDriver driver;

    public ScreenshotUtils(WebDriver driver){
        this.driver = driver;
    }

    public void screenShot(String fileName) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver;
        File source = ss.getScreenshotAs(OutputType.FILE);
        File destination = new File("reports/Screenshots/" + fileName + ".png");
        FileUtils.copyFile(source,destination);


    }
}
