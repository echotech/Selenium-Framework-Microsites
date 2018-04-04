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
//    @FindBy(id = "signupEmailInput")
//    WebElement signupEmailInput;
//    @FindBy(id = "signupPasswordInput")
//    WebElement signupPasswordInput;
//    @FindBy(id = "signupButton")
//    WebElement signupButton;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "personalPhone")
    WebElement personalPhone;
    @FindBy(id = "companyName")
    WebElement companyName;
    @FindBy(id = "street1")
    WebElement street1;
    @FindBy(id = "street2")
    WebElement street2;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "zip")
    WebElement zip;
    @FindBy(id = "addressBlockError")
    WebElement addressBlockError;
    @FindBy(id = "logoURL")
    WebElement logoUrl;
    @FindBy(id = "phone")
    WebElement phone;
    @FindBy(id = "2q5")
    WebElement checkbox;
    @FindBy(id = "nextStepButton")
    WebElement nextStepButton;
    @FindBy(id = "previousStepButton")
    WebElement previousStepButton;

    public boolean personalInformation(String personFirstName, String personLastName, String phoneNumber) {

        logger.debug("Starting test with first name: " + personFirstName + ", last name: " + personLastName + " and phone number: " + phoneNumber);
        boolean hasTextInputError;
        boolean hasPhoneNumberError;

        h.waitForElement(firstName);
        firstName.sendKeys(personFirstName);
        lastName.sendKeys(personLastName);
        personalPhone.sendKeys(phoneNumber);
        h.scrollToAndClickElement(nextStepButton, 0);
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            hasTextInputError = driver.findElements(By.id("textInputError")).size() > 0;
            hasPhoneNumberError = driver.findElements(By.id("phoneInputError")).size() > 0;

            if (hasTextInputError || hasPhoneNumberError) {
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

    public boolean businessInformation(String compName, String streetOne, String streetTwo, String companyCity, String companyState, String companyZip, String companyUrl, String companyPhone, Boolean agreedToTerms) {

        logger.debug("Starting test with Company Name: " + compName + ", Street 1: " + streetOne + ", Street 2 (Optional): " + streetTwo + ", City: " + companyCity + ", State: " + companyState + ", zip: " + companyZip + ", Company URL: " + companyUrl + " and Company Phone Number: " + companyPhone);
        boolean hasTextInputError;
        boolean hasCompanyAddressError;
        boolean hasPhoneNumberError;
        boolean checkboxIsNotChecked;

        h.scrollToAndClickElement(companyName, 0);
        companyName.sendKeys(compName);
        street1.sendKeys(streetOne);
        street2.sendKeys(streetTwo);
        city.sendKeys(companyCity);
        state.sendKeys(companyState);
        zip.sendKeys(companyZip);
        logoUrl.sendKeys(companyUrl);
        phone.sendKeys(companyPhone);
        if (agreedToTerms) {
            h.scrollToAndClickElement(checkbox, 0);
        }
        h.scrollToAndClickElement(nextStepButton, 0);
        try {
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            hasTextInputError = driver.findElements(By.id("textInputError")).size() > 0;
            hasCompanyAddressError = driver.findElements(By.id("addressBlockError")).size() > 0;
            hasPhoneNumberError = driver.findElements(By.id("phoneInputError")).size() > 0;
            checkboxIsNotChecked = driver.findElements(By.id("2q5")).size() > 0;

            if (hasTextInputError || hasCompanyAddressError || hasPhoneNumberError || checkboxIsNotChecked) {
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

