package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpcomingHondaBikesPage extends HomePage{

    public UpcomingHondaBikesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[contains(@title,'upcoming Honda bikes')]")
    WebElement hondaButton;

    @FindBy(xpath = "//h2[contains(@class,'mt')]")
    WebElement hondaPageText;

    @FindBy(xpath = "//img[contains(@class,'lazy')]")
    List<WebElement> bikesImages;

    public void clickHondaButton(){
        javaScriptUtil.scrollIntoView(hondaButton);
        javaScriptUtil.clickElement(hondaButton);
    }

    public WebElement getHondaPageText(){
        return hondaPageText;
    }

    public boolean isBikeImageDisplayed(){
        for(WebElement bikes : bikesImages){
            if(!bikes.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
