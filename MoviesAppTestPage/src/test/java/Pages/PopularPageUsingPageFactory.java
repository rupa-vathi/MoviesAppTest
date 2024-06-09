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

public class PopularPageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "movie-icon-item")
    List<WebElement> MovieImage;
    @FindBy(className = "movie-details-container")
    WebElement movieDetailsPage;
    public PopularPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public boolean checkMoviesDisplay(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        return MovieImage.get(index).isDisplayed();
    }
    public int checkNumberOfMoviesDisplayed(){
        int count=0;
        for(int i=0;i<30;i++){
            if(checkMoviesDisplay(i)){
                count++;
            }
        }
        return count;
    }
    public void clickOnImage(int index){
        if(checkMoviesDisplay(index)){
        MovieImage.get(index).click();}
    }
    public boolean redirectToMovieDetailsPage(){
        return movieDetailsPage.isDisplayed();
    }
}
