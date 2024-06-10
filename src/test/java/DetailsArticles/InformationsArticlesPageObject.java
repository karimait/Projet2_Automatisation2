package DetailsArticles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class InformationsArticlesPageObject {



    public final static String CONSENT_XPATH = "//button[@aria-label='Consent']";
    public final static String ACCOUNT_XPATH = "//li[@id='menu-item-50']/a";
    public final static String USERNAME_XPATH = "//input[@id='username']";
    public final static String PASSWORD_XPATH = "//input[@id='password']";
    public final static String LOGIN_XPATH = "/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/form/p[3]/input[3]";
    public final static String ITEMS_XPATH = "//nav[@class='woocommerce-MyAccount-navigation']/ul";
    public final static String SHOP_XPATH  = "//*[@id='menu-item-40']/a";
    public final static String ADD_XPATH = "//*[@id='content']/ul/li[7]/a[2]";

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
    @FindBy(how = How.XPATH, using = ITEMS_XPATH)
    public WebElement items;
    @FindBy(how = How.XPATH, using = SHOP_XPATH)
    public WebElement shop;

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

    public ArrayList<String> getNavigation(){
        ArrayList<String> ret = new ArrayList<>();
        List<WebElement> list = this.items.findElements(By.xpath(".//li[*]/a"));
        for(WebElement el : list){
            ret.add(el.getText());
        }
        return ret;
    }

    public void clickShop(){
        this.shop.click();
    }


}
