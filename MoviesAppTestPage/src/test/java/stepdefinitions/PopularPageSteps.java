package stepdefinitions;

import Pages.HeaderSectionUsingPageFactory;
import Pages.PopularPageUsingPageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PopularPageSteps {
    WebDriver driver = Hooks.getDriver();
    HeaderSectionUsingPageFactory headerSection=new HeaderSectionUsingPageFactory(driver);
    PopularPageUsingPageFactory popularPage=new PopularPageUsingPageFactory(driver);
    @When("I navigate to popular page")
    public void navigate_to_popular_page(){
        headerSection.NavigateToPopular();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "Navigate to popular page failed");
    }
    @Then("I verify the list of movies displayed in popular page")
    public void verify_list_of_movies(){
        Assert.assertEquals(popularPage.checkNumberOfMoviesDisplayed(),30,"total number of movies expected");
    }
    @Then("I click on movie and redirect to the movie details page")
    public void click_on_movie(){
        if(popularPage.checkMoviesDisplay(5)){
            popularPage.clickOnImage(5);
            Assert.assertTrue(popularPage.redirectToMovieDetailsPage(),"Successfully redirect to the movie details page");
        }
    }
}
