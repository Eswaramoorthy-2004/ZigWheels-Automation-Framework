package testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigWheelsAutomation.pages.LoginPage;

import java.util.Set;

public class TC_17_InvalidEmail extends BaseTest {
    LoginPage glp;
    @Test
    public void invalidEmail(){
        glp=new LoginPage(driver);
        glp.goLogin();
        glp.clickGoogle();
        String oldWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String w : windows){
            if(w!=oldWindow){
                driver.switchTo().window(w);
            }
        }
        if(driver.getWindowHandle()!=oldWindow) {
            glp.setInvalidEmail("bob@.com");
            glp.clickNext();
            //System.out.println(glp.getErrorMessage());
            Assert.assertEquals(glp.getErrorMessage(),"Enter a valid email or phone number");
        }

    }

}
