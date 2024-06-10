package initpassword;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InitPasswordPageObject {
    public final static String CONSENT_XPATH = "//button[@aria-label='Do not consent']";
    public final static String ACCOUNT_XPATH = "//li[@id='menu-item-50']/a";
    public final static String LINK_XPATH = "//a[contains(@href, 'lost')]";
    public final static String EMAIL_XPATH = "//input[@id='user_login']";
    public final static String RESET_XPATH = "//input[@type='submit']";
    public final static String MSG_XPATH = "//div[@class='woocommerce-message']";
    public final static String ERR_XPATH = "//ul[@class='woocommerce-error']";

    @FindBy(how = How.XPATH, using = CONSENT_XPATH)
    public WebElement consent;
    @FindBy(how = How.XPATH, using = ACCOUNT_XPATH)
    public WebElement account;
    @FindBy(how = How.XPATH, using = LINK_XPATH)
    public WebElement link;
    @FindBy(how = How.XPATH, using = EMAIL_XPATH)
    public WebElement email;
    @FindBy(how = How.XPATH, using = RESET_XPATH)
    public WebElement submit;
    @FindBy(how = How.XPATH, using = MSG_XPATH)
    public WebElement msg;
    @FindBy(how = How.XPATH, using = ERR_XPATH)
    public WebElement err;

    public void consent(){
        this.consent.click();
    }
    public void account() {
        this.account.click();
    }
    public void link(){
        this.link.click();
    }
    public void email(String mail){
        this.email.sendKeys(mail);
    }
    public void submitBtn(){
        this.submit.click();
    }

    public String getMessageOK(){
        return this.msg.getText();
    }

    public String getMessageErr(){
        return this.err.getText();
    }

}
