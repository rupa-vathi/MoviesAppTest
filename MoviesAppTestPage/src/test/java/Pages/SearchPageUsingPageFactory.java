package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "search-movies-container")
    WebElement searchMovies;
    @FindBy(className = "search-button")
    WebElement searchBtn;
    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(className = "movie-icon-item")
    List<WebElement> listOfMovies;
    @FindBy(className = "not-found-search-container")
    WebElement notFound;
    public SearchPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public void searchMovies(String name){
        searchInput.sendKeys(name);
        searchBtn.click();
    }
    public void clearSearch(){
        searchInput.clear();
    }
    public boolean redirectToPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-movies-container")));
        return searchMovies.isDisplayed();
    }
    public boolean notFoundContainer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("not-found-search-container")));
        return notFound.isDisplayed();
    }
    public int countMovies(){
        return listOfMovies.size();
    }
}
