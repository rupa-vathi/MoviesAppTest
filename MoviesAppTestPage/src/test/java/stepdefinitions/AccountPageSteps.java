package stepdefinitions;

import Pages.AccountPageUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPageSteps {
    WebDriver driver=Hooks.getDriver();
    AccountPageUsingPageFactory accountPage=new AccountPageUsingPageFactory(driver);
    @Then("I test all UI elements on the page")
    public void TestAccountPageUI(){
        Assert.assertEquals(accountPage.getHeadOfAccPage(),"Account","Heading not matched");
        System.out.println(accountPage.getHeadOfMemberShip());
        System.out.println(accountPage.getMemberShipDetails());
        System.out.println(accountPage.getPlanDetails());
    }
    @And("I test the logout functionality")
    public void LogoutFunctionality(){
        accountPage.ClickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login","logout function failed");
    }
}
