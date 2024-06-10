package logo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class LogoStepDef {

    private WebDriver driver;
    private Wait wait;
    private LogoPageObject logopageobject = new LogoPageObject();
    public LogoStepDef(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, logopageobject);
    }
    @Given("la page a tester {string}")
    public void laPageATester(String url) {
        this.driver.navigate().to(url);
        this.driver.manage().window().maximize();
    }

    @Given("j'enleve la pop up")
    public void j_enleve_la_pop_up() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogoPageObject.CONSENT_XPATH)));
        this.logopageobject.consent();
    }
    @Then("je dois voir le logo")
    public void je_dois_voir_le_logo() throws IOException {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LogoPageObject.SRC_XPATH)));
        URL url = new URL(this.logopageobject.image());
        BufferedImage img = ImageIO.read(url);
        Assertions.assertNotNull(img);
        // TODO find an OCR => AT
    }

}
