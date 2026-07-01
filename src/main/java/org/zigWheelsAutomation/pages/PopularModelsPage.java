package org.zigWheelsAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

        cityInput.clear();
        cityInput.sendKeys(city);

        String cityXpath = "//*[@id=\"popularCityList\"]/li[7]/a";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cityOption = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(cityXpath))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", cityOption);
        js.executeScript("arguments[0].click();", cityOption);

    }

    public int getModelCount() {

        return popularModels.size();
    }

    public void printModels() {

        for (WebElement model : popularModels) {
            String name = model.getText().trim();
            if (!name.isEmpty()) {
                System.out.println(name);
            }
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
