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
    @FindBy(className = "similar-movies-heading")
    WebElement similarMoviesHeading;
    @FindBy(css = "ul.similar-movies-list-container>li")
    List<WebElement> similarMoviesList;
    @FindBy(css = "svg[class $='google-icon']")
    WebElement googleIcon;
    @FindBy(css = "svg[class $='twitter-icon']")
    WebElement twitterIcon;
    @FindBy(css = "svg[class $='instagram-icon']")
    WebElement instagramIcon;
    @FindBy(css = "svg[class $='youtube-icon']")
    WebElement youtubeIcon;
    @FindBy(className = "contact-us-paragraph")
    WebElement contactUs;
    public MoviesDetailsUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public boolean getTitleOfMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
        return movieTitle.isDisplayed();
    }
    public boolean getOverViewOfMovie(){
        return movieOverview.isDisplayed();
    }
    public boolean checkPlayBtn(){
        return playBtn.isDisplayed();
    }
    public boolean movieReviewContainer(){
        boolean time=watchTime.isDisplayed();
        boolean rating=sensorRating.isDisplayed();
        boolean year=releaseYear.isDisplayed();
        return time && rating && year;
    }
    public boolean genreOfMovie(){
        boolean heading=genreHeading.isDisplayed();
        boolean para=true;
        for(int i=0;i<genreText.size();i++){
            para=para && genreText.get(i).isDisplayed();
        }
        return heading && para;
    }
    public String genreHeading(){
        return genreHeading.getText();
    }
    public String audioHeading(){
        return audioHeading.getText();
    }
    public boolean audioOptionsInMovie(){
        boolean heading=audioHeading.isDisplayed();
        boolean para=true;
        for (int i=0;i<audioText.size();i++){
            para=para && audioText.get(i).isDisplayed();
        }
        return heading && para;
    }
    public boolean getRatingHeading(int index){
        return ratingHeading.get(index).isDisplayed();
    }
    public String getRatingHeadings(int index){
        return ratingHeading.get(index).getText();
    }
    public boolean getRatingText(int index){
        return ratingText.get(index).isDisplayed();
    }
    public boolean getBudgetHeading(int index){
        return budgetHeading.get(index).isDisplayed();
    }
    public String getBudgetHeadings(int index){
        return budgetHeading.get(index).getText();
    }
    public boolean getBudgetText(int index){
        return budgetText.get(index).isDisplayed();
    }
    public String getSimilarMoviesHeading(){
        return similarMoviesHeading.getText();
    }
    public int getCountOfSimilarMovies(){
        return similarMoviesList.size();
    }
    public boolean checkFooterSection(){
        return googleIcon.isDisplayed() && twitterIcon.isDisplayed() && instagramIcon.isDisplayed() && youtubeIcon.isDisplayed();
    }
    public String getContactUsHeading(){
        return contactUs.getText();
    }
    public boolean getRating(){
        return sensorRating.isDisplayed();
    }
    public boolean getReleaseYear(){
        return releaseYear.isDisplayed();
    }
    public boolean getWatchTime(){
        return watchTime.isDisplayed();
    }
}
