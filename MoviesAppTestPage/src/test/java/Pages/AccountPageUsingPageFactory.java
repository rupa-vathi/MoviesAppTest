package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "account-heading")
    WebElement accHeading;
    @FindBy(css = "div[class *=membership-container]>p")
    WebElement memHeading;
    @FindBy(className = "membership-password")
    WebElement memPsw;
    @FindBy(className = "membership-username")
    WebElement memUsername;
    @FindBy(css = "div[class *=plan-container]>p")
    WebElement planHeading;
    @FindBy(className = "plan-paragraph")
    WebElement planPara;
    @FindBy(className = "plan-details")
    WebElement planDetails;
    @FindBy(className = "logout-button")
    WebElement logoutBtn;

    public AccountPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getHeadOfAccPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-heading")));
        return accHeading.getText();
    }
    public boolean isGetHeadOfAccPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-heading")));
        return accHeading.isDisplayed();
    }
    public String getHeadOfMemberShip(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class *=membership-container]>p")));
        return memHeading.getText();
    }
    public boolean isGetHeadOfMemberShip(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class *=membership-container]>p")));
        return memHeading.isDisplayed();
    }
    public String getMemberShipDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("membership-username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("membership-password")));
        return memUsername.getText()+" , "+memPsw.getText();
    }
    public boolean isGetMemberShipDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("membership-username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("membership-password")));
        return memUsername.isDisplayed() && memPsw.isDisplayed();
    }
    public String getPlanDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class *=plan-container]>p")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("plan-paragraph")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("plan-details")));
        return planHeading.getText()+" : "+planPara.getText()+", "+planDetails.getText();
    }
    public boolean isGetPlanDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class *=plan-container]>p")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("plan-paragraph")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("plan-details")));
        return planHeading.isDisplayed() && planPara.isDisplayed() && planDetails.isDisplayed();
    }
    public void ClickOnLogout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout-button")));
        logoutBtn.click();
    }


}
