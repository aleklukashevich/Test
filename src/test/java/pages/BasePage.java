package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import webdriver.Browser;

abstract class BasePage{
        //TODO do not extend
    protected WebDriverWait wait;
    protected WebDriver driver;


     BasePage(){
         driver = Browser.getDriver();
         wait = new WebDriverWait(driver,60);
         PageFactory.initElements(new HtmlElementDecorator(driver) {
         }, this);
    }
}
