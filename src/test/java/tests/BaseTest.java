package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import webdriver.Browser;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void init(){
       driver = Browser.getDriver();
       driver.manage().window().maximize();
    }

    @Test
    public abstract void run();

    @AfterClass
    public void tearDown(){ Browser.close(); }

}
