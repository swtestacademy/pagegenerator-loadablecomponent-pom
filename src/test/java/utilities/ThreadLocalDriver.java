package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//**********************************************************************************************************
//Author: Onur Baskirt
//Description: For thread-safe parallel test executions, we should use ThreadLocal concurrent map.
//**********************************************************************************************************
public class ThreadLocalDriver {

    //Declare a ThreadLocal AndroidDriver for Thread-Safe executions to run tests in parallel without any problem.
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    //Set driver to tlDriver
    public synchronized static void setDriver (String browser) {
        if (browser.equals("firefox")) {
            tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(OptionsManager.getFirefoxOptions()));
        } else if (browser.equals("chrome")) {
            tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(OptionsManager.getChromeOptions()));
        }
    }

    //Get driver from tlDriver
    public synchronized static WebDriver getDriver () {
        return tlDriver.get();
    }
}