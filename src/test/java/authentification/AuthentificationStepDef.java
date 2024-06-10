package authentification;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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

public class AuthentificationStepDef {

    private WebDriver driver;
    private Wait wait;
    private AuthentificationPageObject authentification = new AuthentificationPageObject();
    public AuthentificationStepDef() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, authentification);
    }

    @Given("connexion à la page {string}")
    public void connexion_à_la_page(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.CONSENT_XPATH)));
        this.authentification.consent();
    }
    @When("je clique sur le lien my Account")
    public void je_clique_sur_le_lien_my_account() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.ACCOUNT_XPATH)));
        this.authentification.account();
    }
    @When("je saisie mon email {string}")
    public void je_saisie_mon_email(String email) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.USERNAME_XPATH)));
        this.authentification.username(email);
    }
    @When("je saisie mon password {string}")
    public void je_saisie_mon_password(String password) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.PASSWORD_XPATH)));
        this.authentification.password(password);
    }
    @And("je clique pas sur remeber me")
    public void jeCliquePasSurRemeberMe() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.REMEBER_ME_XPATH)));
        this.authentification.rememberMe();
    }
    @When("je clique sur le bouton de login")
    public void je_clique_sur_le_bouton_de_login() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.LOGIN_XPATH)));
        this.authentification.login();
    }
    @Then("je visualise les elements suivant Dashboard , Orders, Download, Adresses, Account Details, Logout")
    public void je_visualise_les_elements_suivant_dashboard_orders_download_adresses_account_details_logout() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.ITEMS_XPATH)));
        ArrayList<String> nav = this.authentification.getNavigation();
        String []dashboard = new String[]{ "Dashboard", "Orders", "Downloads" ,"Addresses", "Account Details" , "Logout" };
        for(int i = 0; i < dashboard.length; i++) {
            Assertions.assertEquals(nav.get(i), dashboard[i]);
        }

    }

    @Then("un message d'erreur apparait à l'ecran")
    public void un_message_d_erreur_apparait_à_l_ecran() {
        String error = this.authentification.getErrorMessage();
        Assertions.assertTrue(error.contains("Error"));
        System.out.println("👍");
    }

    @And("je clique sur le lien <Logout>")
    public void jeCliqueSurLeLienLogout() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AuthentificationPageObject.LOGOUT_XPATH)));
        this.authentification.logout();
    }

    @Then("L'email et le meme et le mot de passe est rempli")
    public void lEmailEtLeMemeEtLeMotDePasseEstRempli() {

    }
}
