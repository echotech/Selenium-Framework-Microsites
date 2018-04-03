package test;

import base.TestBase;
import io.codearte.jfairy.producer.person.Person;
import org.testng.annotations.Test;
import page.LoginPage;
import page.SignUpPage;
import page.SurveyPage;
import util.DataGenerator;

import static org.testng.Assert.*;

public class LoginTests extends TestBase {

    //Login Page LoginTests
    @Test
    public void testLoginInvalidBoth(){
        setMobileTest(false);
        setHeadless(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@test.com", "test1"), true);
    }

    @Test
    public void testLoginInvalidUser(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","invalidUser@test.com", "testing123"), true);
    }

    @Test
    public void testLoginInvalidPass(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", "invalid"), true);
    }

    @Test
    public void testLoginValid(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", "testing123"), false);
    }

    @Test
    public void testBlankPass(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", ""), true);
    }

    @Test
    public void testSignUp(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals("https://stageearlypay.apio.tech/login/#/new_account", l.signupTest("https://stageearlypay.apio.tech/login/"));
    }




    // Sign Up Page Tests

//    @Test
//    public void testAllSignUp() {
//        testSignUpInvalidBoth();
//        testSignUpInvalidUser();
//        testSignUpInvalidPass();
//        testSignUpValid();
//        testSignUpBlankPass();
//        testToLogin();
//    }

    @Test
    public void testSignUpInvalidBoth() {
        setMobileTest(false);
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@test.com", "test1"));
    }

    @Test
    public void testSignUpInvalidUser() {
        setMobileTest(false);
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "invalid@", "testing123"));
        assertTrue(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", ".invalid@test.com", "testing123"));
        assertTrue(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "@test.com", "testing123"));
    }

    @Test
    public void testSignUpInvalidPass() {
        setMobileTest(false);
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@apio.tech", "invalid"));
    }

    @Test
    public void testSignUpValid() {
        setMobileTest(false);
        SignUpPage signUpPage = new SignUpPage(driver);
        // Create a new email with the prefix, "test+"
        DataGenerator dataGenerator = new DataGenerator();
        String userEmail = "test+" + dataGenerator.getPerson().getEmail();
        assertFalse(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", userEmail, "testing123"));
    }

    @Test
    public void testSignUpBlankPass() {
        setMobileTest(false);
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@apio.tech", ""));
    }

    @Test
    public void testToLogin() {
        setMobileTest(false);
        SignUpPage signUpPage = new SignUpPage(driver);
        assertEquals(signUpPage.toLoginTest("https://stageearlypay.apio.tech/login/#/new_account"), "https://stageearlypay.apio.tech/login/#/");
    }


    // Survey Page Tests
    @Test
    public void testBlankFirstName() {
        testSignUpValid();

        setMobileTest(false);
        SurveyPage surveyPage = new SurveyPage(driver);

        DataGenerator dataGenerator = new DataGenerator();
        Person person = dataGenerator.getPerson();
        String lastName = person.getLastName();
        String phoneNumber = person.getTelephoneNumber();

        assertTrue(surveyPage.personalInformation(" ", lastName, phoneNumber));

    }

}
