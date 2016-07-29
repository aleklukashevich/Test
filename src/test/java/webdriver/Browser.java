package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Aleksandr on 28.07.2016.
 */
public class Browser {
    private static WebDriver driver;

    private Browser(){}

    public static WebDriver getDriver(){
        if(driver == null){
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void open(String urlSite){
        driver.get(urlSite);
    }

    public static void close(){
        try{
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver = null;
        }
    }
}
