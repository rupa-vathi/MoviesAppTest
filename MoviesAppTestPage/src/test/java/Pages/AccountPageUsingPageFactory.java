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
        return accHeading.getText();
    }
    public String getHeadOfMemberShip(){
        return memHeading.getText();
    }
    public String getMemberShipDetails(){
        return memUsername.getText()+" , "+memPsw.getText();
    }
    public String getPlanDetails(){
        return planHeading.getText()+" : "+planPara.getText()+", "+planDetails.getText();
    }
    public void ClickOnLogout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout-button")));
        logoutBtn.click();
    }


}
