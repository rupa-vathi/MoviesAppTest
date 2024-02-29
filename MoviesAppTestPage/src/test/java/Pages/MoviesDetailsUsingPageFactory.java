package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MoviesDetailsUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "movie-title")
    @CacheLookup
    WebElement movieTitle;
    @FindBy(className = "watch-time")
    WebElement watchTime;
    @FindBy(className = "sensor-rating")
    WebElement sensorRating;
    @FindBy(className = "release-year")
    WebElement releaseYear;
    @FindBy(className = "movie-overview")
    WebElement movieOverview;
    @FindBy(className = "play-button")
    WebElement playBtn;
    @FindBy(css = "div.genres-category p")
    List<WebElement> genreText;
    @FindBy(css = "div.genres-category h1")
    WebElement genreHeading;
    @FindBy(css = "div.audio-category p")
    List<WebElement> audioText;
    @FindBy(css = "div.audio-category h1")
    WebElement audioHeading;
    @FindBy(css = "div.rating-category p")
    List<WebElement> ratingText;
    @FindBy(css = "div.budget-category p")
    List<WebElement> budgetText;
    @FindBy(css = "div.rating-category h1")
    List<WebElement> ratingHeading;
    @FindBy(css = "div.budget-category h1")
    List<WebElement> budgetHeading;
    public MoviesDetailsUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public String getTitleOfMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
        return movieTitle.getText();
    }
    public String getOverViewOfMovie(){
        return movieOverview.getText();
    }
    public boolean checkPlayBtn(){
        return playBtn.isDisplayed();
    }
    public String movieReviewContainer(){
        String time=watchTime.getText();
        String rating=sensorRating.getText();
        String year=releaseYear.getText();
        return time+" "+rating+" "+year;
    }
    public String genreOfMovie(){
        String heading=genreHeading.getText();
        String para="";
        for(int i=0;i<genreText.size();i++){
            para+=genreText.get(i).getText()+" ";
        }
        return heading+" : "+para;
    }
    public String audioOptionsInMovie(){
        String heading=audioHeading.getText();
        String para="";
        for (int i=0;i<audioText.size();i++){
            para+=audioText.get(i).getText()+" ";
        }
        return heading+" : "+para;
    }
    public String getRatingHeading(int index){
        return ratingHeading.get(index).getText();
    }
    public String getRatingText(int index){
        return ratingText.get(index).getText();
    }
    public String getBudgetHeading(int index){
        return budgetHeading.get(index).getText();
    }
    public String getBudgetText(int index){
        return budgetText.get(index).getText();
    }

}
