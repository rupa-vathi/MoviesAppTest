package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
      driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}