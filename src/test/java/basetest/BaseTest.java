package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.zigWheelsAutomation.utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    PropertyReader p;

    @BeforeClass
    public void setup() throws IOException {
        driver = new ChromeDriver();
        p = new PropertyReader();
        driver.get(p.getPageURL());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }


}
