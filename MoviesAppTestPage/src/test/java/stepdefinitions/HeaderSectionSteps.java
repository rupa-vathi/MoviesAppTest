package stepdefinitions;

import Pages.HeaderSectionUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderSectionSteps {
    WebDriver driver=Hooks.getDriver();
    HeaderSectionUsingPageFactory headerSection=new HeaderSectionUsingPageFactory(driver);
    @Then("I Test whether the Website logo is displayed")
    public void test_Header() {
        Assert.assertTrue(headerSection.checkWebsiteLogo(), "Website logo not found");
    }
    @And("I Test the Navbar elements")
    public void test_navbar_elements(){
        Assert.assertEquals(headerSection.checkNavElements(0),"Home","Home Nav link not found");
        Assert.assertEquals(headerSection.checkNavElements(1),"Popular","Popular Nav link not found");
        Assert.assertTrue(headerSection.checkSearchIcon(),"Search Icon not displayed");
        Assert.assertTrue(headerSection.checkAvatarIcon(),"Avtar Icon not displayed");
    }
    @Then("I Test the navigation to the Home and Popular pages")
    public void navigate_to_the_pages() {
        headerSection.NavigateToPopular();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "Navigate to papular page failed");
        headerSection.NavigateToHome();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Navigate to home page failed");
        headerSection.NavigateToSearchPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/search");
    }
    @And("I Test the navigation to the account page")
    public void navigate_to_account_page(){
        headerSection.navigateAccountPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/account","Navigate to account page failed");
    }

}
