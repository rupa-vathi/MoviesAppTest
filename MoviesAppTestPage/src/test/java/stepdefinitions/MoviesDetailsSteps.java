package stepdefinitions;

import Pages.HomePageUsingPageFactory;
import Pages.MoviesDetailsUsingPageFactory;
import Pages.PopularPageUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MoviesDetailsSteps {
    WebDriver driver = Hooks.getDriver();
    HomePageUsingPageFactory homePage=new HomePageUsingPageFactory(driver);
    PopularPageUsingPageFactory popularPage=new PopularPageUsingPageFactory(driver);
    MoviesDetailsUsingPageFactory movieDetails=new MoviesDetailsUsingPageFactory(driver);
    @When("I click on any one movie on home page")
    public void clickOnMovieOnHomePage(){
        homePage.clickOnTrendingNowMovies(2);
    }
    @Then("I test all the UI elements present in it")
    public void testFunctionalities(){
        System.out.println(movieDetails.getTitleOfMovie());
        System.out.println(movieDetails.getOverViewOfMovie());
        System.out.println(movieDetails.movieReviewContainer());
        Assert.assertTrue(movieDetails.checkPlayBtn(),"play button not displayed");
        System.out.println(movieDetails.genreOfMovie());
        System.out.println(movieDetails.audioOptionsInMovie());
        System.out.println(movieDetails.getRatingHeading(0)+" : "+movieDetails.getRatingText(0));
        System.out.println(movieDetails.getRatingHeading(1)+" : "+movieDetails.getRatingText(1));
        System.out.println(movieDetails.getBudgetHeading(0)+" : "+movieDetails.getBudgetText(0));
        System.out.println(movieDetails.getBudgetHeading(1)+" : "+movieDetails.getBudgetText(1));
    }
    @And("I click on any one movie on popular page")
    public void clickOnMovieOnPopularPage(){
        popularPage.clickOnImage(5);
    }
}
