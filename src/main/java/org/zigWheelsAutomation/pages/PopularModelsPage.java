package org.zigWheelsAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.zigWheelsAutomation.utilities.WaitUtil;
import java.util.List;

public class PopularModelsPage extends UsedCarsPage {
    WaitUtil waitUtil;

    public PopularModelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(@id,'mmvLi')]")
    List<WebElement> popularModels;

    @FindBy(xpath = "//*[@id='gs_input5']")
    WebElement cityInput;

    @FindBy(xpath = "//h1[@id='usedcarttlID']")
    WebElement usedCarsHeader;

    @FindBy(xpath = "//span[contains(@class,'zw-sr-frstLevActive')]")
    WebElement brandAndModelExpandedIcon;

    @FindBy(xpath = "//div[contains(text(),'Popular Models')]")
    WebElement popularModelsHeader;

    public void selectCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
        String cityXpath = "//*[@id='popularCityList']/li[7]/a";
        waitUtil = new WaitUtil(driver);
        WebElement cityOption = waitUtil.waitForVisibilityOfElementLocated(By.xpath(cityXpath));
        javaScriptUtil.clickElement(cityOption);
    }

    public int getModelCount() {
        return popularModels.size();
    }

    public void printModels() {
        int count = driver.findElements(
                By.xpath("//li[contains(@id,'mmvLi')]")).size();
        for (int i = 0; i < count; i++) {
            List<WebElement> freshModels = driver.findElements(
                    By.xpath("//li[contains(@id,'mmvLi')]"));
            try {
                String text = freshModels.get(i).getText().trim();
                if (!text.isEmpty()) {
                    System.out.println(text);
                }}
            catch (Exception ignored) {

            }
        }
    }
    public String getSelectedCity() {
        return cityInput.getAttribute("value");
    }

    public boolean isPopularModelsDisplayed() {
        return popularModelsHeader.isDisplayed();
    }

    public String getUsedCarsHeaderText() {
        return usedCarsHeader.getText();
    }

    public boolean isBrandAndModelExpanded() {
        return brandAndModelExpandedIcon.isDisplayed();
    }
}