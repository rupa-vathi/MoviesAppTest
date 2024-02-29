package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.List;
public class HeaderSectionUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "website-logo")
    WebElement websiteLogo;
    @FindBy(xpath = "//ul/li/a")
    List<WebElement> navbarElements;
    @FindBy(xpath = "//a[text()='Home']")
    @CacheLookup
    WebElement homeLink;
    @FindBy(xpath = "//ul[@class='nav-menu-list']/li[2]/a")
    @CacheLookup
    WebElement popularLink;
    @FindBy(className = "search-empty-button")
            @CacheLookup
    WebElement searchBtn;
    @FindBy(className = "avatar-button")
    WebElement accountPage;
    public HeaderSectionUsingPageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public boolean checkWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        return websiteLogo.isDisplayed();
    }
    public String checkNavElements(int index){
        return navbarElements.get(index).getText();
    }
    public void navigateAccountPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));
        accountPage.click();
    }
    public boolean checkSearchIcon(){
        return searchBtn.isDisplayed();
    }
    public boolean checkAvatarIcon(){
        return accountPage.isDisplayed();
    }
    public void NavigateToHome(){
        homeLink.click();
    }
    public void NavigateToPopular(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav-menu-list']/li[2]/a")));
        popularLink.click();
    }
    public void NavigateToSearchPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-empty-button")));
        searchBtn.click();
    }
}
