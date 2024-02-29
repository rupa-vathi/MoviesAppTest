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

public class LoginPageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "login-website-logo")
    @CacheLookup
    WebElement websiteLogo;
    @FindBy(className = "sign-in-heading")
    @CacheLookup
    WebElement headingText;
    @FindBy(id = "usernameInput")
    @CacheLookup
    WebElement usernameInput;
    @FindBy(id = "passwordInput")
    @CacheLookup
    WebElement passwordInput;
    @FindBy(className = "login-button")
    @CacheLookup
    WebElement loginBtn;
    @FindBy(className="input-label" )
    @CacheLookup
    List<WebElement> inputLabels;
    @FindBy(className = "error-message")
    @CacheLookup
    WebElement errorMsg;
    public LoginPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public boolean checkImageIsDisplayed(){
        return websiteLogo.isDisplayed();
    }
    public String getHeadingText(){
        return headingText.getText();
    }
    public void enterUserName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameInput")));
        (usernameInput).sendKeys(name);
    }
    public void enterPassword(String psw){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordInput")));
        (passwordInput).sendKeys(psw);
    }
    public void clearInputs(){
        usernameInput.clear();
        passwordInput.clear();
    }
    public void clickONLoginBtn(){
                        (loginBtn).click();
    }
    public void loginToApplications(String name,String psw){
        enterUserName(name);
        enterPassword(psw);
        clickONLoginBtn();
    }
    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return (errorMsg).getText();
    }
    public String getTextContentOfLabel(int index){
        return (inputLabels).get(index).getText();
    }
    public boolean checkLoginButtonIsDisplayed(){
        return loginBtn.isDisplayed();
    }

}
