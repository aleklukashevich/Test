package pages;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

public class EBoxPage extends BasePage {

    @FindBy(xpath = ".//a[contains(text(),'Входящие')]")
    private Link inbox;

    @FindBy(xpath = "//*[@class='block-messages-wrap']//div[contains(@class,'js-message-id')]")
    private List<Link> messagesList;

    public int getInboxMessagesCount(){
        inbox.click();
        return messagesList.size();
    }

}
