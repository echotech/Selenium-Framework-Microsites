package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Helpers;

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

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "personalPhone")
    WebElement personalPhone;
    @FindBy(id = "nextStepButton")
    WebElement nextStepButton;
    @FindBy(id = "previousStepButton")
    WebElement previousStepButton;

    public boolean personalInformation(String personFirstName, String personLastName, String phoneNumber) {

        logger.debug("Starting test with first name: " + personFirstName + ", last name: " + personLastName + " and phone number: " + phoneNumber);
        boolean hasTextInputError;
        boolean hadPhoneNumberError;

//        driver.navigate().to(url);
        h.waitForElement(firstName);
        firstName.sendKeys(personFirstName);
        lastName.sendKeys(personLastName);
        personalPhone.sendKeys(phoneNumber);
        h.scrollToAndClickElement(nextStepButton, 0);
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            hasTextInputError = driver.findElements(By.id("textInputError")).size() > 0;
            hadPhoneNumberError = driver.findElements(By.id("phoneInputError")).size() > 0;

            if (hasTextInputError || hadPhoneNumberError) {
                logger.error("Invalid Information");
                return true;
            } else {
                logger.debug("Valid Information");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
