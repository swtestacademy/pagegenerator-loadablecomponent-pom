package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //Test Data
    private String wrongUsername = "onur@swtestacademy.com";
    private String wrongPassword = "11122233444";

    @BeforeMethod(description = "Method Level Setup!")
    public void loginSetup() {
        //*************PAGE INSTANTIATIONS************* (No Need to declare explicitly.)
        //homePage = new HomePage(driver);
        //loginPage = new LoginPage(driver, homePage);

        //*************PAGE METHODS********************
        //Open N11 HomePage and Go to Login Page
        page.loginPage().get();
    }

    @Test (description="Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {
        //*************PAGE METHODS********************
        page.loginPage().loginToN11(wrongUsername, wrongPassword);

        //*************ASSERTIONS***********************
        page.loginPage().verifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test (description="Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword ()  {
        //*************PAGE INSTANTIATIONS*************
        page.loginPage().loginToN11("","");

        //*************ASSERTIONS***********************
        page.loginPage().verifyLoginUserName("Lütfen e-posta adresinizi girin.");
        page.loginPage().verifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }
}
