package com.seleniumbddcvdemo.pages;

import com.seleniumbddcvdemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Registration successful')]")
    WebElement registerSuccessText;

    public String verifyRegisterSuccessText(){
        log.info("Verify Register Success Text:");
        return getTextFromElement(registerSuccessText);
    }
    public void clickOnRegisterLink() {
        log.info("Clicking on register link :");
        clickOnElement(registerLink);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    public void verifyLoginButtonDisable(){
        verifyThatElementIsDisplayed(loginButton);
    }
    public void login(String uName,String pwd){
        sendTextToElement(username,uName);
        sendTextToElement(password,pwd);
        clickOnElement(loginButton);
    }

}
