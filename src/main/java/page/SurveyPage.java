package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;
import org.slf4j.*;

import java.util.concurrent.TimeUnit;

public class SurveyPage {
    private WebDriver driver;
    private Helpers h;
    static Logger logger = LoggerFactory.getLogger(SurveyPage.class);

    public SurveyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        h = new Helpers(driver);
    }

    //Elements
    @FindBy(id = "signupEmailInput")
    WebElement signupEmailInput;
    @FindBy(id = "signupPasswordInput")
    WebElement signupPasswordInput;
    @FindBy(id = "signupButton")
    WebElement signupButton;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "personalPhone")
    WebElement personalPhone;
    @FindBy(id = "signupToggleButton")
    WebElement signupToggleButton;

    public boolean businessSignUpTest(String url, String username, String password) {

        logger.debug("Starting test with username: "+ username + "password: " + password);
        boolean isPresent;
        boolean isNullPw;
        driver.navigate().to(url);
        h.waitForElement(signupEmailInput);
        signupEmailInput.sendKeys(username);
        signupPasswordInput.sendKeys(password);
        h.scrollToAndClickElement(signupButton, 0);
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            isPresent = driver.findElements(By.xpath("//div[contains(@class, 'notification') and @style='']")).size() > 0;
            isNullPw = driver.findElements(By.xpath("//span[contains(@class, 'help is-danger') and @style='']")).size() > 0;

            if (isPresent || isNullPw) {
                logger.error("Invalid Credentials");
                return true;
            } else {
                logger.debug("Valid Credentials");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public String toLoginTest(String url){
        driver.navigate().to(url);
        h.scrollToAndClickElement(signupToggleButton,0);
        return driver.getCurrentUrl();
    }


}

