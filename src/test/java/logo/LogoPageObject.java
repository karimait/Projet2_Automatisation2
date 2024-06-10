package logo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoPageObject {
    public final static String CONSENT_XPATH = "//button[@aria-label='Do not consent']";
    public final static String SRC_XPATH = "//img[contains(@title, 'Site')]";

    @FindBy(how = How.XPATH, using = CONSENT_XPATH)
    public WebElement consent;
    @FindBy(how = How.XPATH, using = SRC_XPATH)
    public WebElement img;

    public void consent(){
        this.consent.click();
    }

    public String image(){
        return this.img.getAttribute("src");
    }
}
