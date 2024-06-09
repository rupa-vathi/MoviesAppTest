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
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    @When("I navigate to popular page")
    public void navigate_to_popular_page(){
        headerSection.NavigateToPopular();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "Navigate to the popular page failed to test");
    }
    @Then("I verify the list of movies displayed in popular page")
    public void verify_list_of_movies(){
        Assert.assertEquals(popularPage.checkNumberOfMoviesDisplayed(),30,"Total number of movies count not as expected");
    }
    @Then("I click on movie and redirect to the movie details page")
    public void click_on_movie(){
            Assert.assertTrue(popularPage.checkMoviesDisplay(5),"The Movie which I was click is not displayed as expected");
            popularPage.clickOnImage(5);
            Assert.assertTrue(popularPage.redirectToMovieDetailsPage(),"Successfully redirect to the movie details page failed to test");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/284a2caa-59d4-46b4-88bc-31a0eb07f622";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "Redirect to the movie details page in popular page failed.");

    }
}
