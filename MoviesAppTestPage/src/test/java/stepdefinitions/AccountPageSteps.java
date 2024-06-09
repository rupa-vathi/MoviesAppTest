package stepdefinitions;

import Pages.AccountPageUsingPageFactory;
import Pages.HeaderSectionUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPageSteps {
    WebDriver driver=Hooks.getDriver();
    AccountPageUsingPageFactory accountPage=new AccountPageUsingPageFactory(driver);
    HeaderSectionUsingPageFactory headerSection=new HeaderSectionUsingPageFactory(driver);
    @When("I Test navigation to the account page")
    public void navigate_to_the_account_page(){
        headerSection.navigateAccountPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/account","Navigate to account page failed");
    }
    @Then("I test all UI elements on the page")
    public void TestAccountPageUI(){
        Assert.assertTrue(accountPage.isGetHeadOfAccPage(), "The Heading of the account page is not displayed");
        Assert.assertEquals(accountPage.getHeadOfAccPage(),"Account","The Heading of account page not matched as expected. Actual text: "+accountPage.getHeadOfAccPage());
        Assert.assertTrue(accountPage.isGetHeadOfMemberShip(), "The Membership heading is not displayed");
        Assert.assertEquals(accountPage.getHeadOfMemberShip(),"Member ship","The Member ship heading not match as expected. Actual text: "+accountPage.getHeadOfMemberShip());
        Assert.assertTrue(accountPage.isGetMemberShipDetails(), "The Membership details are not displayed");
        Assert.assertEquals(accountPage.getMemberShipDetails(),"User name : rahul"+" , " +"Password : **********","The Membership details not match as expected.Actual text: "+accountPage.getMemberShipDetails());
        Assert.assertTrue(accountPage.isGetPlanDetails(), "The Plan details are not displayed");
        Assert.assertEquals(accountPage.getPlanDetails(),"Plan details" + " : " + "Premium" + ", " + "Ultra HD","The Plan Details not match as expected.Actual Text: "+accountPage.getPlanDetails());
    }
    @And("I test the logout functionality")
    public void LogoutFunctionality(){
        accountPage.ClickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login","logout URL do not match");
    }
}
