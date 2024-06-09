package stepdefinitions;

import Pages.HomePageUsingPageFactory;
import Pages.MoviesDetailsUsingPageFactory;
import Pages.PopularPageUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MoviesDetailsSteps {
    WebDriver driver = Hooks.getDriver();
    HomePageUsingPageFactory homePage=new HomePageUsingPageFactory(driver);
    PopularPageUsingPageFactory popularPage=new PopularPageUsingPageFactory(driver);
    MoviesDetailsUsingPageFactory movieDetails=new MoviesDetailsUsingPageFactory(driver);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    @When("I click on any one movie on home page")
    public void clickOnMovieOnHomePage(){
        homePage.clickOnTrendingNowMovies(2);
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/c6ef2389-078a-4117-b2dd-1dee027e5e8e";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URLs do not match");
    }
    @Then("I test all the UI elements present in it")
    public void testFunctionalities(){
        Assert.assertTrue(movieDetails.getTitleOfMovie(),"The Movie Title is not found in the page");
        Assert.assertTrue(movieDetails.getOverViewOfMovie(),"The Overview of the movie element not found");
        Assert.assertTrue(movieDetails.movieReviewContainer(),"The Movie Review Container not found in the given page");
        Assert.assertTrue(movieDetails.checkPlayBtn(),"The Play button Image is not displayed as expected");
        Assert.assertEquals(movieDetails.audioHeading(),"Audio Available","The Audio Options heading did not match the expected text.");
        Assert.assertEquals(movieDetails.genreHeading(),"Genres", "The Genres heading did not match the expected text.");
        Assert.assertTrue(movieDetails.genreOfMovie(),"The Genre of the movie not displayed as expected");
        Assert.assertTrue(movieDetails.audioOptionsInMovie(),"The Audio options Icon is not displayed as expected");
        Assert.assertEquals(movieDetails.getRatingHeadings(0),"Rating Count","The Rating count heading is not displayed as expected");
        Assert.assertEquals(movieDetails.getRatingHeadings(1),"Rating Average","The Rating Average heading is not displayed as expected");
        Assert.assertTrue(movieDetails.getRatingHeading(0) && movieDetails.getRatingText(0),"The Rating heading and text not match the expected");
        Assert.assertTrue(movieDetails.getRatingHeading(1) && movieDetails.getRatingText(1),"The Rating Heading and text 2 not match the expected");
        Assert.assertTrue(movieDetails.getBudgetHeading(0) && movieDetails.getBudgetText(0),"The Budget heading and text not match the expected text");
        Assert.assertTrue(movieDetails.getBudgetHeading(1) && movieDetails.getBudgetText(1),"The Budget heading and text 2 not match the expected text");
        Assert.assertEquals(movieDetails.getBudgetHeadings(0),"Budget","The Budget heading is not displayed as expected");
        Assert.assertEquals(movieDetails.getBudgetHeadings(1),"Release Date","The Release date heading is not displayed as expected");
        Assert.assertEquals(movieDetails.getSimilarMoviesHeading(),"More like this","The heading for similar movies did not match the expected text. Actual heading: "+ movieDetails.getSimilarMoviesHeading());
        Assert.assertTrue(movieDetails.getCountOfSimilarMovies() > 0, "No similar movies found on the page");
        Assert.assertTrue(movieDetails.getRating(), "The Rating is not displayed as expected");
        Assert.assertTrue(movieDetails.getReleaseYear(), "The Release Year is not displayed as expected");
        Assert.assertTrue(movieDetails.getWatchTime(), "The Watch Time is not displayed as expected");
    }
    @And("I click on any one movie on popular page")
    public void clickOnMovieOnPopularPage(){
        popularPage.clickOnImage(5);
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/284a2caa-59d4-46b4-88bc-31a0eb07f622";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URLs do not match");
    }
    @And("I test the footer section")
    public void testTheFooterSection(){
        Assert.assertTrue(movieDetails.checkFooterSection(),"The footer section icons were not displayed as expected");
        Assert.assertEquals(movieDetails.getContactUsHeading(),"Contact Us","The contact us heading text did not match the expected value. Actual heading: " + movieDetails.getContactUsHeading());
    }
}
