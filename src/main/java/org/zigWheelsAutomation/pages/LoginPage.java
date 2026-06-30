package org.zigWheelsAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="des_lIcon")
    WebElement login;

    @FindBy(xpath="//span[text()='Google']")
    WebElement google;

    @FindBy(xpath = "//span[text()='Next']")
    WebElement next;

    @FindBy(id="identifierId")
    WebElement emailInput;


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

}
