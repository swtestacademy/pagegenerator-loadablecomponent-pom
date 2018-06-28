package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.Page;
import utilities.ThreadLocalDriver;

public class BaseTest {
    protected WebDriverWait wait;
    protected Page page;

    @BeforeMethod(description = "Class Level Setup!")
    @Parameters(value = {"browser"})
    public void globalSetup (@Optional String browser) {
        //Set ThreadLocal Driver
        ThreadLocalDriver.setDriver(browser);

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(ThreadLocalDriver.getDriver(), 15);

        //Maximize Window
        //ThreadLocalDriver.getDriver().manage().window().maximize();

        //Page Generator instance
        page = new Page ();
    }

    @AfterMethod(description = "Class Level Teardown!")
    public void globalTearDown() {
        ThreadLocalDriver.getDriver().quit();
    }

}
