package org.zigWheelsAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class UsedCarsPage {

    public WebDriver driver;

    public UsedCarsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='headerNewVNavWrap']/nav/ul/li[5]/span")
    WebElement moreMenu;

    @FindBy(xpath = "//*[@id=\"headerNewVNavWrap\"]/nav/ul/li[5]/ul/li[2]/a")
    WebElement usedCarsOption;

    public void clickMore() {
        moreMenu.click();
    }

    public void clickUsedCars() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", usedCarsOption);
        js.executeScript("arguments[0].click();", usedCarsOption);

    }}