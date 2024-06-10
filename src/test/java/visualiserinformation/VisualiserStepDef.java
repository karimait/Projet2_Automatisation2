package visualiserinformation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VisualiserStepDef {
    private WebDriver driver;
    private Wait wait;
    private VisualiserPageObject visualiserPageObject = new VisualiserPageObject();
    public VisualiserStepDef(){
        this.driver = new FirefoxDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, visualiserPageObject);
    }
    @Given("je suis sur mon compte")
    public void je_suis_sur_mon_compte() {

    }

    @When("je clique sur le lien Account Details")
    public void je_clique_sur_le_lien_account_details() {

    }

    @When("je clique sur <Password Change>")
    public void je_clique_sur_password_change() {

    }

    @When("je saisie mon password actuel {string}")
    public void je_saisie_mon_password_actuel(String pass) {

    }

    @When("je clique sur <New Password>")
    public void je_clique_sur_new_password() {

    }

    @When("j'injecte mon nouveau password {string}")
    public void j_injecte_mon_nouveau_password(String new_pass) {

    }

    @When("je clique <Confirm New Password>")
    public void je_clique_confirm_new_password() {

    }

    @When("je confirme mon nouveau password {string}")
    public void je_confirme_mon_nouveau_password(String string) {

    }

    @When("je clique sur le bouton <SAVE CHANGES>")
    public void je_clique_sur_le_bouton_save_changes() {

    }

    @Then("je reçois un message d'erreur")
    public void je_reçois_un_message_d_erreur() {

    }

}
