package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    //Test Data
    private String wrongUsername = "onur@swtestacademy.com";
    private String wrongPassword = "11122233444";

    @BeforeMethod(description = "Method Level Setup!")
    public void loginSetup() {
        //Open N11 HomePage and Go to Login Page
        page.loginPage().get();
    }

    @Test (description="Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {
        page.loginPage()
                .WhenILoginToN11(wrongUsername, wrongPassword)
                .ThenIVerifyLoginPassword(("E-posta adresiniz veya şifreniz hatalı"));
    }

    @Test (description="Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword ()  {
        page.loginPage()
                .WhenILoginToN11("","")
                .ThenIVerifyLoginUserName("Lütfen e-posta adresinizi girin.")
                .ThenIVerifyLoginPassword("Bu alanın doldurulması zorunludur.");
    }
}
