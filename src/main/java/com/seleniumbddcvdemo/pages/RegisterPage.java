package com.seleniumbddcvdemo.pages;

import com.seleniumbddcvdemo.utility.Utility;
import cucumber.api.java.zh_cn.假如;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Register')]")
    WebElement registerText;

    public String verifyRegisterText() {
        log.info("Verify Register Text");
        return getTextFromElement(registerText);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement registerFirstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Text1']")
    WebElement registerLastNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='username']")
    WebElement registerUserNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement registerPasswordNameField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerButton;


    public void registerForm(String fName, String lName, String uName, String pass) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElement(registerFirstNameField, fName);
        Thread.sleep(2000);
        log.info("Enter User First Name:");
        sendTextToElement(registerLastNameField, lName);
        Thread.sleep(2000);
        log.info("Enter User Last Name:");
        sendTextToElement(registerUserNameField, uName);
        Thread.sleep(2000);
        log.info("Enter User Name:");
        sendTextToElement(registerPasswordNameField, pass);
        Thread.sleep(2000);
        log.info("Enter Password:");
        clickOnElement(registerButton);
        log.info("Click On Register Button:");

    }

}
