package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends LoadableComponent<LoginPage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;
    private final String loginURL = "https://www.n11.com/giris-yap";

    //*********Constructor*********
    public LoginPage (WebDriver driver) {
         this.driver = driver;
         this.wait = new WebDriverWait(driver,10);
         basePage = new BasePage(this.driver);
    }

    //*********Web Elements*********
    By usernameBy = By.id("email");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("loginButton");
    By errorMessageUsernameBy = By.cssSelector("#loginForm .error:nth-of-type(1) .errorMessage");
    By errorMessagePasswordBy = By.cssSelector("#loginForm .error:nth-of-type(2) .errorText");

    //*********Override LoadableComponent Methods*********
    //We need to go to the basePage at load method
    @Override
    protected void load() {
        basePage.page.homePage().goToLoginPage();
    }

    //We need to check that the basePage has been loaded.
    @Override
    protected void isLoaded() throws Error {
        assertTrue("LoginPage is not loaded!", driver.getCurrentUrl().contains(loginURL));
    }

    //*********Page Methods*********
    public void loginToN11 (String username, String password){
        //Enter Username(Email)
        basePage.writeText(usernameBy,username);
        //Enter Password
        basePage.writeText(passwordBy, password);
        //Click Login Button
        basePage.click(usernameBy); //In order to click right, this line needed. Site related.
        basePage.click(loginButtonBy);
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageUsernameBy));
        Assert.assertEquals(basePage.readText(errorMessageUsernameBy), expectedText);
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagePasswordBy));
        Assert.assertEquals(basePage.readText(errorMessagePasswordBy), expectedText);
    }
}
