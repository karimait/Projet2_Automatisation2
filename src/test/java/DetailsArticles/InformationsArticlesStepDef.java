package DetailsArticles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class InformationsArticlesStepDef {

    private WebDriver driver;
    private Wait wait;
    private InformationsArticlesPageObject detailsarticles = new InformationsArticlesPageObject();

    public InformationsArticlesStepDef() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, detailsarticles);
    }

    @Given("Je suis sur la page d'accueil du site web {string}")
    public void je_suis_sur_la_page_d_accueil_du_site_web(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @When("je clique sur le bouton Consent")
    public void je_clique_sur_le_bouton_consent() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.CONSENT_XPATH)));
        this.detailsarticles.consent();
    }

    @When("Je clique sur le lien My Account")
    public void je_clique_sur_le_lien_my_account() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.ACCOUNT_XPATH)));
        this.detailsarticles.account();

    }
    @When("Je saisis mon adresse email valide {string}")
    public void je_saisis_mon_adresse_email_valide(String email) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.USERNAME_XPATH)));
        this.detailsarticles.username(email);
    }

    @When("Je saisis mon mot de passe correct {string}")
    public void je_saisis_mon_mot_de_passe_correct(String password) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.PASSWORD_XPATH)));
        this.detailsarticles.password(password);
    }


    @When("Je clique sur le bouton LOGIN")
    public void je_clique_sur_le_bouton_login() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.LOGIN_XPATH)));
        this.detailsarticles.login();
    }

    @Then("Je suis redirigé vers la page Dashboard")
    public void jeSuisRedirigéVersLaPageDashboard(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.ITEMS_XPATH)));
        ArrayList<String> nav = this.detailsarticles.getNavigation();
        String []dashboard = new String[]{ "Dashboard", "Orders", "Downloads" ,"Addresses", "Account Details" , "Logout" };
        for(int i = 0; i < dashboard.length; i++) {
            Assertions.assertEquals(nav.get(i), dashboard[i]);
        }
    }

    @Then("Je clique sur le bouton Shop")
    public void je_clique_sur_le_bouton_shop() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.SHOP_XPATH)));
        this.detailsarticles.clickShop();
    }

    @Then("je clique sur l'article de mon choix")
    public void je_clique_sur_l_article_de_mon_choix() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InformationsArticlesPageObject.SHOP_XPATH)));
        this.detailsarticles.login();
    }

    @Then("l'utilisateur voit la photographie, un détail descriptif, le prix et le nombre d'exemplaires encore disponibles du produit")
    public void l_utilisateur_voit_la_photographie_un_détail_descriptif_le_prix_et_le_nombre_d_exemplaires_encore_disponibles_du_produit() {

    }

}
