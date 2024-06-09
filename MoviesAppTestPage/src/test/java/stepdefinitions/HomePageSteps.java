package stepdefinitions;

import Pages.HomePageUsingPageFactory;
import Pages.LoginPageUsingPageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePageSteps{
    WebDriver driver = Hooks.getDriver();
    LoginPageUsingPageFactory loginPage=new LoginPageUsingPageFactory(driver);
    HomePageUsingPageFactory homePage=new HomePageUsingPageFactory(driver);
    @Given("I am on the home page")
    public void i_am_on_the_home_page(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage.loginToApplications("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Url does not match");
    }
    @When("I view the heading texts of each section")
    public void i_view_the_heading_texts_of_each_section(){
        System.out.println(homePage.checkMovieHead());
        Assert.assertEquals(homePage.checkListHead(0),"Trending Now","Movies List heading 1 not matched");
        Assert.assertEquals(homePage.checkListHead(1),"Originals","Movies List heading 2 not matched");

    }
    @Then("I should see the Movies displayed")
    public void i_should_see_the_movies_displayed(){
        int list1=homePage.checkTrendingNowMovies();
        int list2=homePage.checkOriginalsMovies();
        Assert.assertEquals(list1,10,"count missed in trending now section");
        Assert.assertEquals(list2,10,"count missed in originals section");
        Assert.assertEquals(list1+list2,20,"Images are missed");
    }
    @Then("I check if the play button is displayed")
    public void i_check_if_the_play_button_is_displayed(){
        Assert.assertTrue(homePage.checkPlayBtn(),"Play button not displayed");
    }
    @Then("I should see the Contact Us section displayed")
    public void i_should_see_the_contact_us_section_displayed(){
        Assert.assertTrue(homePage.checkFooterSection1(),"Google icon not displayed");
        Assert.assertTrue(homePage.checkFooterSection3(),"twitter icon not displayed");
        Assert.assertTrue(homePage.checkFooterSection2(),"instagram icon not displayed");
        Assert.assertTrue(homePage.checkFooterSection4(),"youtube icon not displayed");
        Assert.assertEquals(homePage.getTextOfContactUs(),"Contact Us","Missing contact us Text");
    }
}
