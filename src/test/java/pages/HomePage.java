package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class HomePage extends LoadableComponent<HomePage> {

    //*********Page Variables*********
    private String baseURL = "https://www.n11.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        basePage = new BasePage(this.driver);
    }

    //*********Web Elements*********
    By signInButtonBy = By.className("btnSignIn");

    //*********Override LoadableComponent Interface Methods*********
    //We need to go to the basePage at load method
    @Override
    public void load() {
        this.driver.get(baseURL);
    }

    //We need to check that the basePage has been loaded.
    @Override
    public void isLoaded() throws Error {
        assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(baseURL));
    }

    //*********Page Methods*********
    //Go to LoginPage
    public LoginPage goToLoginPage (){
        basePage.click(signInButtonBy);
        return new LoginPage(this.driver);
    }

}
