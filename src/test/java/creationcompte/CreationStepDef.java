package creationcompte;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreationStepDef {

    private WebDriver driver;
    private Wait wait;
    private CreationPageObject creationpageobject = new CreationPageObject();
    public CreationStepDef() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, creationpageobject);
    }
    @Given("Je suis sur la page {string}")
    public void je_suis_sur_la_page(String url) {
        this.driver.navigate().to(url);
        this.driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreationPageObject.CONSENT_XPATH)));
        this.creationpageobject.consent();
    }

    @When("je clique sur My account")
    public void je_clique_sur_my_account() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreationPageObject.ACCOUNT_XPATH)));
        this.creationpageobject.account();
    }
    @When("je rentre un email {string}")
    public void je_rentre_un_email(String email) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreationPageObject.EMAIL_XPATH)));
        this.creationpageobject.email(email);
    }
    @When("je rentre un password {string}")
    public void je_rentre_un_password(String password) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreationPageObject.PASSWORD_XPATH)));
        this.creationpageobject.password(password);
    }
    @When("je clique sur le bouton register")
    public void je_clique_sur_le_bouton_register() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CreationPageObject.REGISTER_XPATH)));
        this.creationpageobject.register();
    }
    @Then("je reste sur la page")
    public void je_reste_sur_la_page() {
        String msg = this.creationpageobject.getTitle();
        Assertions.assertEquals(msg, "Register");

    }


}
