package com.seleniumbddcvdemo.steps;

import com.seleniumbddcvdemo.pages.LoginPage;
import com.seleniumbddcvdemo.pages.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class RegisterSteps {


    @When("^I click on register link$")
    public void iClickOnRegisterLink() {
        new LoginPage().clickOnRegisterLink();
    }

    @Given("^I am on Login Page$")
    public void iAmOnHomepage() {
    }

    @And("^I on Register page and verify a text \"([^\"]*)\"$")
    public void iOnRegisterPageAndVerifyAText(String reg)  {

        String actualRegisterText =new RegisterPage().verifyRegisterText();
        Assert.assertEquals(reg,actualRegisterText,"validation register text");

    }

    @And("^I fill up all field in register form\\.$")
    public void iFillUpAllFieldInRegisterForm(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            new RegisterPage().registerForm(columns.get("FName"), columns.get("LName"), columns.get("UName"), columns.get("Password"));

        }
    }

    @And("^I verify user is \"([^\"]*)\" text$")
    public void iVerifyUserIsText(String regSuccessText)  {
        String actualResult = new LoginPage().verifyRegisterSuccessText();
        Assert.assertEquals(regSuccessText,actualResult,"Validation Register Success Text");
    }
}