package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "home-movie-heading")
    @CacheLookup
    WebElement homeMovieHead;
    @FindBy(className = "home-movie-play-button")
    WebElement playBtn;
    @FindBy(className = "movies-list-heading")
    @CacheLookup
    List<WebElement> moviesListHeading;
    @FindBy(xpath = "//h1[text()='Trending Now']/following::img[not(preceding::h1[text()='Originals'])]")
    @CacheLookup
    List<WebElement> listOfTrendingNowMovies;
    @FindBy(xpath = "//h1[text()='Originals']/following::img")
    @CacheLookup
    List<WebElement> listOfOriginalsMovies;
    @FindBy(css = "svg[class *='google']")
    WebElement googleIcon;
    @FindBy(css = "svg[class *='twitter']")
    WebElement twitterIcon;
    @FindBy(css = "svg[class *='instagram']")
    WebElement instagramIcon;
    @FindBy(css = "svg[class *='youtube']")
    WebElement youtubeIcon;
    @FindBy(css = "p[class *='contact']")
    WebElement contactUsText;

    public HomePageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public String checkMovieHead(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-heading")));
        return homeMovieHead.getText();
    }
    public String checkListHead(int index){
        return moviesListHeading.get(index).getText();
    }
    public boolean checkPlayBtn(){
        return playBtn.isDisplayed();
    }
    public int checkTrendingNowMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Trending Now']/following::img[not(preceding::h1[text()='Originals'])]")));
        return listOfTrendingNowMovies.size();
    }
    public void clickOnTrendingNowMovies(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Trending Now']/following::img[not(preceding::h1[text()='Originals'])]")));
        listOfTrendingNowMovies.get(index).click();
    }
    public int checkOriginalsMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Originals']/following::img")));
        return listOfOriginalsMovies.size();
    }
    public void clickOnOriginalsMovies(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Originals']/following::img")));
        listOfOriginalsMovies.get(index).click();
    }
    public boolean checkFooterSection1(){
        return googleIcon.isDisplayed();
    }
    public boolean checkFooterSection2(){ return instagramIcon.isDisplayed();}
    public boolean checkFooterSection3(){return twitterIcon.isDisplayed();}
    public boolean checkFooterSection4(){  return youtubeIcon.isDisplayed();}
    public String getTextOfContactUs(){
        return contactUsText.getText();
    }

}
