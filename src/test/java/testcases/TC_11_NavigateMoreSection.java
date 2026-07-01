package testcases;
import basetest.BaseTest;
import org.testng.annotations.*;
import org.zigWheelsAutomation.pages.UsedCarsPage;

public class TC_11_NavigateMoreSection extends BaseTest {

    @Test
    public void openWebsiteAndMore(){
        UsedCarsPage page = new UsedCarsPage(driver);
        page.clickMore();

        System.out.println("More section opened successfully");
    }
}
