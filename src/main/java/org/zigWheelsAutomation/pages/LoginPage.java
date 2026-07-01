package org.zigWheelsAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

import static java.time.Duration.*;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String oldWindowX;
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    @FindBy(id="des_lIcon")
    WebElement login;

    @FindBy(xpath="//span[text()='Google']")
    public WebElement google;

    @FindBy(xpath = "//span[text()='Facebook']")
    public WebElement facebook;

    @FindBy(xpath = "//span[text()='Apple']")
    public WebElement apple;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement next;

    @FindBy(id="identifierId")
    public WebElement emailInput;

    @FindBy(xpath = "//div[@id='i8']")
    WebElement errorMsg;

    @FindBy(xpath = "//h1[@id='headingText']")
    public WebElement pageTitle;


    public void goLogin(){
        login.click();
        oldWindowX = driver.getWindowHandle();
    }
    public void clickGoogle() throws InterruptedException {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            google.click();
            try {
                new WebDriverWait(driver, Duration.ofSeconds(3))
                        .until(ExpectedConditions.numberOfWindowsToBe(2));
                break;
            } catch (TimeoutException e) {
            }
        }
    }
    public void switchWindow(){
        Set<String> windowsIds = driver.getWindowHandles();
        for(String w : windowsIds){
            if(!w.equals(oldWindowX)){
                driver.switchTo().window(w);
                break;
            }
        }
    }

    public void enterEmailOrPhone(String email){
        emailInput.sendKeys(email);
    }

    public void clickNext(){
        next.click();
    }

    public String getErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }

}
