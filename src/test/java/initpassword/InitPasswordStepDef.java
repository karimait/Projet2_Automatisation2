package initpassword;

import io.cucumber.java.en.And;
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

public class InitPasswordStepDef {
    private WebDriver driver;
    private Wait wait;
    private InitPasswordPageObject initPasswordPage = new InitPasswordPageObject();
    public InitPasswordStepDef() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, initPasswordPage);
    }

    @Given("je suis sur la page de connexion {string}")
    public void jeSuisSurLaPageDeConnexion(String url) {
        this.driver.navigate().to(url);
        this.driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.CONSENT_XPATH)));
        this.initPasswordPage.consent();
    }

    @And("je clique sur le lien My account")
    public void jeCliqueSurLeLienMyAccount() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.ACCOUNT_XPATH)));
        this.initPasswordPage.account();
    }

    @When("je clique sur le lien <Lost your password?>")
    public void jeCliqueSurLeLienLostYourPassword() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.RESET_XPATH)));
        this.initPasswordPage.link();
    }

    @And("j'injecte mon e-mail {string}")
    public void jInjecteMonEMail(String mail) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.EMAIL_XPATH)));
        this.initPasswordPage.email(mail);
    }


    @And("je clique sur le bouton <Reset Password>")
    public void jeCliqueSurLeBoutonResetPassword() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.RESET_XPATH)));
        this.initPasswordPage.submitBtn();
    }

    @Then("je reçois un message de confirmation")
    public void je_reçois_un_message_de_confirmation() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.MSG_XPATH)));
        String msgOk = this.initPasswordPage.getMessageOK();
        Assertions.assertTrue(msgOk.contains("Password reset"));
        System.out.println(msgOk);
    }

    @Then("je dois voir un message d'erreur")
    public void je_dois_voir_un_message_d_erreur() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(InitPasswordPageObject.ERR_XPATH)));
        String nok = this.initPasswordPage.getMessageErr();
        Assertions.assertTrue(nok.contains("Invalid username"));
        System.out.println(nok);
    }

}
