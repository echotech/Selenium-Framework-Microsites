package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;
import org.slf4j.*;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private Helpers h;
    static Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        h = new Helpers(driver);
    }

    //Elements
    @FindBy(xpath = "//input[@placeholder='example@domain.com']")
    WebElement emailField;
    @FindBy(xpath = "//input[@placeholder='password']")
    WebElement passField;
    @FindBy(xpath = "//div[@class='control']/button")
    WebElement signInBtn;
    @FindBy(xpath="//button[contains(@class, 'button is-small is-primary is-outlined left-mar-small')]")
    WebElement signUpBtn;

    public boolean loginTest(String url, String username, String password) {

        logger.debug("Starting test with username: "+ username + "password: " + password);
        boolean isPresent;
        boolean isNullPw;
        driver.navigate().to(url);
        h.waitForElement(emailField);
        emailField.sendKeys(username);
        passField.sendKeys(password);
        h.scrollToAndClickElement(signInBtn, 0);
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

    public String signupTest(String url){
        driver.navigate().to(url);
        h.scrollToAndClickElement(signUpBtn,0);
        return driver.getCurrentUrl();
    }

}
