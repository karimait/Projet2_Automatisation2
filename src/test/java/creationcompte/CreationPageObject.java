package creationcompte;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreationPageObject {
    public final static String CONSENT_XPATH = "//button[@aria-label='Do not consent']";
    public final static String ACCOUNT_XPATH = "//li[@id='menu-item-50']/a";
    public final static String EMAIL_XPATH = "//input[@id='reg_email']";
    public final static String PASSWORD_XPATH = "//input[@id='reg_password']";
    public final static String REGISTER_XPATH = "//input[@name='register']";
    public final static String TITLE_XPATH = "(//h2)[last()]";

    @FindBy(how = How.XPATH, using = CONSENT_XPATH)
    public WebElement consent;
    @FindBy(how = How.XPATH, using = ACCOUNT_XPATH)
    public WebElement account;
    @FindBy(how = How.XPATH, using = EMAIL_XPATH)
    public WebElement email;
    @FindBy(how = How.XPATH, using = PASSWORD_XPATH)
    public WebElement password;
    @FindBy(how = How.XPATH, using = REGISTER_XPATH)
    public WebElement register;
    @FindBy(how = How.XPATH, using = TITLE_XPATH)
    public WebElement title;

    public void consent(){
        this.consent.click();
    }
    public void account(){
        this.account.click();
    }

    public void email(String mail){
        this.email.sendKeys(mail);
    }

    public void password(String passwd){
        this.password.sendKeys(passwd);
    }

    public void register(){
        this.register.click();
    }
    public String getTitle(){
        return this.title.getText();
    }
}
