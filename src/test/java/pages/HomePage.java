package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='authorize']//a[contains(@class,'enter')]")
    private Link enterLink;

    @FindBy(className = "b-popup-i")
    private Form credsForm;

    @FindBy(name = "login")
    private TextInput loginFld;

    @FindBy(name = "password")
    private TextInput pswFld;

    @FindBy(xpath = "//form[@class='auth-form']//input[contains(@class,'button')]")
    private Button enterBtn;

    @FindBy(xpath = "//*[@id='authorize']//a[text()='Почта']")
    private Link emailLink;



    public HomePage login(String id, String psw){
        enterLink.click();
        wait.until(ExpectedConditions.visibilityOf(credsForm.getWrappedElement()));
        loginFld.sendKeys(id);
        pswFld.sendKeys(psw);
        enterBtn.click();
        return this;
    }

    public EBoxPage proceedToTheEBox(){
        enterLink.click();
        emailLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().defaultContent();
        return new EBoxPage();
    }


}
