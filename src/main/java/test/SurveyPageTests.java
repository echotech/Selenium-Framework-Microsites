package test;

import base.TestBase;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Person;
import org.testng.annotations.Test;
import page.SurveyPage;
import util.DataGenerator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SurveyPageTests extends TestBase {

    // Survey Page Tests

    // Personal Information Tests
    @Test
    public void testValidPersonalInfo() {
        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        String phoneNumber = "5555555555";

        SignUpTests signUpTests = new SignUpTests();
        signUpTests.testSignUpValid();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertFalse(surveyPage.personalInformation(firstName, lastName, phoneNumber));

    }

    @Test
    public void testFirstNameWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        String lastName = person.getLastName();
        String phoneNumber = "5555555555";

        SignUpTests signUpTests = new SignUpTests();
        signUpTests.testSignUpValid();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);

        assertTrue(surveyPage.personalInformation(" ", lastName, phoneNumber));
    }

    @Test
    public void testLastNameWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        String firstName = person.getFirstName();
        String phoneNumber = "5555555555";

        SignUpTests signUpTests = new SignUpTests();
        signUpTests.testSignUpValid();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);

        assertTrue(surveyPage.personalInformation(firstName, " ", phoneNumber));
    }

    @Test
    public void testPhoneNumberWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        String firstName = person.getFirstName();
        String lastName = person.getLastName();

        SignUpTests signUpTests = new SignUpTests();
        signUpTests.testSignUpValid();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);

        assertTrue(surveyPage.personalInformation(firstName, lastName, " "));
    }


    // Business Information Tests
    @Test
    public void testValidBusinessInformation() {
        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertFalse(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, true));
    }

    // Test all of the "businessInformationWhitespace()" method tests.
//    @Test
//    public void testAllBusinessInformationWhitespace() {
//        testCompanyNameWhitespace();
//        testStreet1Whitespace();
//        testCityWhitespace();
//        testNoStateSelected();
//        testZipWhitespace();
//        testCompanyUrlWhitespace();
//        testCompanyPhoneWhitespace();
//    }

    // Testing Whitespace
    @Test
    public void testCompanyNameWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(" ", companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, true));
    }

    @Test
    public void testStreet1Whitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = " ";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, true));
    }

    @Test
    public void testCityWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = " ";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, true));
    }

    @Test
    public void testNoStateSelected() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "";
        String companyZip = "88888";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, true));
    }

    @Test
    public void testZipWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = " ";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, true));
    }

    @Test
    public void testCompanyUrlWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, " ", companyPhone, true));
    }

    @Test
    public void testCompanyPhoneWhitespace() {

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyUrl = company.getUrl();

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, " ", true));
    }

    // Testing Checkbox Unchecked
    @Test
    public void testCheckboxUncheckedBusinessInformation() {
        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        Company company = person.getCompany();
        String companyName = company.getName();
        String companyStreet1 = "123 Fake Street";
        String companyStreet2 = "";
        String companyCity = "Provo";
        String companyState = "Utah";
        String companyZip = "88888";
        String companyUrl = company.getUrl();
        String companyPhone = "5555555555";

        testValidPersonalInfo();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);
        assertTrue(surveyPage.businessInformation(companyName, companyStreet1, companyStreet2, companyCity, companyState, companyZip, companyUrl, companyPhone, false));
    }

}

