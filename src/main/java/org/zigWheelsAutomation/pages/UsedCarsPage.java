package org.zigWheelsAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class UsedCarsPage {

    WebDriver driver;

    public UsedCarsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='headerNewVNavWrap']/nav/ul/li[5]/span")
    WebElement moreMenu;

    @FindBy(xpath = "//*[@id=\"headerNewVNavWrap\"]/nav/ul/li[5]/ul/li[2]/a")
    WebElement usedCarsOption;

    @FindBy(xpath = "//*[@id=\"gs_input5\"]")
    WebElement cityInput;

    @FindBy(xpath = "//*[@id='ui-id-5']")
    WebElement selectCity;

    @FindBy(xpath = "//li[contains(@id,'mmvLi')]")
    List<WebElement> popularModels;

    public void clickMore() {
        moreMenu.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

    }

    public void clickUsedCars() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", usedCarsOption);
        js.executeScript("arguments[0].click();", usedCarsOption);

    }
    /*
    public void selectCity(String city) {
        cityInput.sendKeys(city);
        selectCity.click();
    }

    public int getModelCount() {
        return popularModels.size();
    }

    public void printModels() {
        for (WebElement model : popularModels) {
            System.out.println(model.getText());
        }
    }

    public void clickFirstModel() {
        if (popularModels.size() > 0) {
            popularModels.get(0).click();
        }

     */
    }
