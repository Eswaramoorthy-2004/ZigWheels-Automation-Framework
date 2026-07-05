package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.zigWheelsAutomation.utilities.JavaScriptUtil;

public class HomePage {
    WebDriver driver;
    JavaScriptUtil javaScriptUtil;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    @FindBy(xpath = "//span[text()='NEW BIKES']")
    WebElement newBikesElement;

    @FindBy(xpath = "//a[contains(@title,'Upcoming Bikes')]")
    WebElement upcomingBikesElement;

    @FindBy(xpath = "//img[@alt='Home']")
    WebElement pageLogo;

    public void hoverNewBikes(){
        Actions action = new Actions(driver);
        action.moveToElement(newBikesElement).perform();
    }
    public void clickUpcomingBikes(){
        javaScriptUtil.scrollIntoView(upcomingBikesElement);
        javaScriptUtil.clickElement(upcomingBikesElement);

    }
    public boolean checkLogoIsDisplayed(){
        return pageLogo.isDisplayed();
    }
}
