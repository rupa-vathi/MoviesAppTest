package stepdefinitions;

import Pages.HeaderSectionUsingPageFactory;
import Pages.SearchPageUsingPageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

public class SearchPageSteps {
    WebDriver driver = Hooks.getDriver();
    HeaderSectionUsingPageFactory headerSection=new HeaderSectionUsingPageFactory(driver);
    SearchPageUsingPageFactory searchPage=new SearchPageUsingPageFactory(driver);
    @When("I navigate to search page")
    public void navigate_to_search_page(){
        headerSection.NavigateToSearchPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/search");
    }
    @And("I search for \"The GodFather\" Movie")
    public void searchForMovie(){
        searchPage.searchMovies("The GodFather");
    }
    @Then("I should see the count of movies displayed")
    public void countMoviesDisplayed() {
        if (searchPage.redirectToPage()) {
            System.out.println("Search for a movie is successfully completed: " + searchPage.countMovies());
        }
    }
    @Then("I should see not found container")
    public void notfoundContainer(){
        if(searchPage.notFoundContainer()){
            System.out.println("Search for a non-existent movie is successfully completed");
        }
    }
    @And("I search for non-existent Movie")
    public void searchNonExistent(){
       searchPage.clearSearch();
       searchPage.searchMovies("tgd");
    }
}
