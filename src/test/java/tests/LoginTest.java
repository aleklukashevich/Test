package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class LoginTest extends BaseTest{
    private String email;
    private String password;
    private String site;

    @BeforeMethod
    @Parameters({"site","email","password"})
    public void setParameters(String site, String email, String password){
        this.site=site;
        this.email = email;
        this.password = password;
    }

    public void run() {
        driver.get(site);
        int inboxM = new HomePage()
                .login(email,password)
                .proceedToTheEBox()
                .getInboxMessagesCount();

       Assert.assertEquals(inboxM,2,"Email Box contains much more letters, than you've expected to see");
    }
}
