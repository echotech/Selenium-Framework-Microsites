package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private Helpers h;
    static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

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

    public boolean loginTest(String url, String username, String password) {
        boolean isPresent;
        driver.navigate().to(url);
        h.waitForElement(emailField);
        emailField.sendKeys(username);
        passField.sendKeys(password);
        h.scrollToAndClickElement(signInBtn, 0);
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            isPresent = driver.findElements(By.xpath("//div[contains(@class, 'notification') and @style='']")).size() > 0;

            if (isPresent) {
                logger.info("Invalid Credentials");
                return true;
            } else {
                logger.info("Valid Credentials");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
