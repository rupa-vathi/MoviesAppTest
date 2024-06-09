package stepdefinitions;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPageSteps{
    WebDriver driver = Hooks.getDriver();
    LoginPageUsingPageFactory loginPage=new LoginPageUsingPageFactory(driver);

    @Given("I am on the login page")
    public void loginPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }
    @Then("I test the Website logo image should be displayed")
    public void checkWebsiteLogo(){
        Assert.assertTrue(loginPage.checkImageIsDisplayed(), "App logo is not displayed");
    }
    @And("I test the Heading text should be \"Login\"")
    public void checkHeadingText() {
        Assert.assertEquals(loginPage.getHeadingText(), "Login", "Heading text not matched");
    }
    @And("I test the Username label text should be \"USERNAME\"")
    public void testUsernameLabel(){
        Assert.assertEquals(loginPage.getTextContentOfLabel(0), "USERNAME", "Username label text does not match");
    }
    @And("I test the Password label text should be \"PASSWORD\"")
    public void testPasswordLabel(){
        Assert.assertEquals(loginPage.getTextContentOfLabel(1), "PASSWORD", "Password label text does not match");
    }
    @And("I test the \"Login\" button should be present")
    public void checkLoginButton(){
        Assert.assertTrue(loginPage.checkLoginButtonIsDisplayed(), "Login button not displayed");
    }
    @When("I attempt to login with empty input fields")
    public void testLoginWithEmptyInputs() {
        loginPage.loginToApplications("","");
    }
    @Then("I should see an error message")
    public void verifyErrorMessage(){
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid", "Error text with empty input fields does not match");
    }
    @When("I enter a valid password")
    public void testLoginWithEmptyUsername() {
        loginPage.enterPassword("rahul@2021");
        loginPage.clickONLoginBtn();
    }
    @When("I enter a valid username")
    public void testLoginWithEmptyPassword() {
        loginPage.enterUserName("rahul");
        loginPage.clickONLoginBtn();
    }
    @When("I enter invalid credentials")
    public void testLoginWithInvalidCreds() {
        loginPage.loginToApplications("rahul","rahul");
        Assert.assertEquals(loginPage.getErrorMsg(), "*username and password didn't match", "Error fields text does not match");
        loginPage.loginToApplications("rahul@2021","rahul@2021");
        Assert.assertEquals(loginPage.getErrorMsg(), "*username and password didn't match", "Error fields text does not match");
    }
    @When("I enter valid credentials")
    public void testLoginWithValidCredentials() {
        loginPage.loginToApplications("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Url does not match");
    }
}
