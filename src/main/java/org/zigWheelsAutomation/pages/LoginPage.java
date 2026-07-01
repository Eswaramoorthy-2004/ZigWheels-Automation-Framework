package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.*;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="des_lIcon")
    WebElement login;

    @FindBy(xpath="//span[text()='Google']")
    public WebElement google;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement next;

    @FindBy(id="identifierId")
    WebElement emailInput;

    @FindBy(xpath = "//div[@id='i8']")
    WebElement errorMsg;


    public void goLogin(){
        login.click();
    }

    public void clickGoogle(){
        google.click();
    }

    public void setInvalidEmail(String email){
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
