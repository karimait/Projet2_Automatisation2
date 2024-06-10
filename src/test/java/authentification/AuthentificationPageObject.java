package authentification;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AuthentificationPageObject {
    public final static String CONSENT_XPATH = "//button[@aria-label='Do not consent']";
    public final static String ACCOUNT_XPATH = "//li[@id='menu-item-50']/a";
    public final static String USERNAME_XPATH = "//input[@id='username']";
    public final static String PASSWORD_XPATH = "//input[@id='password']";
    public final static String LOGIN_XPATH = "//input[@name='login']";
    public final static String REMEBER_ME_XPATH = "//input[@id='rememberme']";
    public final static String ITEMS_XPATH = "//nav[@class='woocommerce-MyAccount-navigation']/ul";
    public final static String ERROR_XPATH = "(//ul[@class='woocommerce-error'])[1]";
    public final static String LOGOUT_XPATH = "//li[contains(@class, 'customer-logout')]";

    @FindBy(how = How.XPATH, using = CONSENT_XPATH)
    public WebElement consent;
    @FindBy(how = How.XPATH, using = ACCOUNT_XPATH)
    public WebElement account;
    @FindBy(how = How.XPATH, using = USERNAME_XPATH)
    public WebElement username;
    @FindBy(how = How.XPATH, using = PASSWORD_XPATH)
    public WebElement password;
    @FindBy(how = How.XPATH, using = LOGIN_XPATH)
    public WebElement login;
    @FindBy(how = How.XPATH, using = REMEBER_ME_XPATH)
    public WebElement remerberme;
    @FindBy(how = How.XPATH, using = ITEMS_XPATH)
    public WebElement items;
    @FindBy(how = How.XPATH, using = ERROR_XPATH)
    public WebElement error;
    @FindBy(how = How.XPATH, using = LOGOUT_XPATH)
    public WebElement logout;

    public void consent(){
        this.consent.click();
    }
    public void account(){
        this.account.click();
    }
    public void username(String username){
        this.username.sendKeys(username);
    }
    public void password(String password){
        this.password.sendKeys(password);
    }
    public void login(){
        this.login.click();
    }
    public void rememberMe(){
        this.remerberme.click();
    }
    public ArrayList<String> getNavigation(){
        ArrayList<String> ret = new ArrayList<>();
        List<WebElement> list = this.items.findElements(By.xpath(".//li[*]/a"));
        for(WebElement el : list){
            ret.add(el.getText());
        }
        return ret;
    }
    public String getErrorMessage(){
        return this.error.getText();
    }

    public void logout() {
        this.logout.click();
    }

    public String getusername(){
        return this.username.getText();
    }
    public String getpassword(){
        return this.password.getText();
    }
}
