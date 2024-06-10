package ajoutpanier;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjoutPanierStepDef {

    private WebDriver driver;
    private Wait wait;
    private AjoutPanierPageObject ajoutpanier = new AjoutPanierPageObject();

    public AjoutPanierStepDef() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, ajoutpanier);
    }

   @Given("Je suis sur la page d'accueil du site web {string}")
   public void je_suis_sur_la_page_d_accueil_du_site_web(String url) {
       this.driver.navigate().to(url);
       this.driver.manage().window().maximize();
   }

    @When("je clique sur le bouton Consent panier")
    public void je_clique_sur_le_bouton_consent_panier() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.CONSENT_XPATH)));
        this.ajoutpanier.consent();
    }

    @When("Je clique sur le lien My Account ajout panier")
    public void je_clique_sur_le_lien_my_account_ajout_panier() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.ACCOUNT_XPATH)));
        this.ajoutpanier.account();
    }

    @When("Je saisis mon adresse email valide panier {string}")
    public void je_saisis_mon_adresse_email_valide_panier(String email) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.USERNAME_XPATH)));
        this.ajoutpanier.username(email);
    }

    @When("Je saisis mon mot de passe correct ajout panier {string}")
    public void je_saisis_mon_mot_de_passe_correct_ajout_panier(String password) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.PASSWORD_XPATH)));
        this.ajoutpanier.password(password);
    }

    @When("Je clique sur le bouton LOGIN panier")
    public void je_clique_sur_le_bouton_login_panier() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.LOGIN_XPATH)));
        this.ajoutpanier.login();
    }

    @Then("Je clique sur le bouton Shop")
    public void je_clique_sur_le_bouton_shop() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.SHOP_XPATH)));
       this.ajoutpanier.clickShop();
    }

    @Then("je clique sur l'article de mon choix ADDBASKET")
    public void je_clique_sur_l_article_de_mon_choix_addbasket() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.ADDBASKET_XPATH)));
        this.ajoutpanier.clickaddbasket();
    }

    @Then("je clique pour visualiser le panier VIEWBASKET")
    public void je_clique_pour_visualiser_le_panier_viewbasket() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AjoutPanierPageObject.VIEWBASKET_XPATH)));
        this.ajoutpanier.clickviewbasket();
    }

    @Then("l'utilisateur voit la photographie, un détail descriptif, le prix et le nombre d'exemplaires encore disponibles du produit")
    public void l_utilisateur_voit_la_photographie_un_détail_descriptif_le_prix_et_le_nombre_d_exemplaires_encore_disponibles_du_produit() {

    }


}
