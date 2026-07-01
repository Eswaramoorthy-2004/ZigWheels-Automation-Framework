package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class PopularModelsPage {

    WebDriver driver;

    public PopularModelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@id,'mmvLi')]")
    List<WebElement> popularModels;

    @FindBy(xpath = "//*[@id=\"gs_input5\"]")
    WebElement cityInput;

    @FindBy(xpath = "//*[@id='ui-id-5']")
    WebElement selectCity;

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
    public String getSelectedCity() {
        return cityInput.getAttribute("value");
    }

    public void clickFirstModel() {
        if (popularModels.size() > 0) {
            popularModels.get(0).click();
        }
    }
}
