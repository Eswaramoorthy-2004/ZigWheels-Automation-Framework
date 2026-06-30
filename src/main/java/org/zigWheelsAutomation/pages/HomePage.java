package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='NEW BIKES']")
    WebElement newBikesElement;

    @FindBy(xpath = "//a[contains(@title,'Upcoming Bikes')]")
    WebElement upcomingBikesElement;

    public void hoverNewBikes(){
        Actions action = new Actions(driver);
        action.moveToElement(newBikesElement).perform();
    }
    public void clickUpcomingCars(){
        upcomingBikesElement.click();
    }
}
