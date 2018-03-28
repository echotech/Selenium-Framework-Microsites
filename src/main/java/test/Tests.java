package test;

import base.TestBase;
import org.testng.annotations.Test;
import page.LoginPage;
import page.SurveyPage;

import static org.testng.Assert.*;

public class Tests extends TestBase {

    //Login Page Tests
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
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","invalid@test.com", "testing123"), true);
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

//    @Test
//    public void forgotPassword(){
//
//    }
//
//
//    @Test
//    public void changePassword(){
//
//    }

    // Survey Page Tests
    @Test
    public void testGetStartedInvalidBoth() {
        setMobileTest(false);
        SurveyPage s = new SurveyPage(driver);
        assertTrue(s.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@test.com", "test1"));
    }

    @Test
    public void testGetStartedInvalidUser() {
        setMobileTest(false);
        SurveyPage s = new SurveyPage(driver);
        assertTrue(s.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "invalid@test.com", "testing123"));
    }

    @Test
    public void testGetStartedInvalidPass() {
        setMobileTest(false);
        SurveyPage s = new SurveyPage(driver);
        assertTrue(s.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@apio.tech", "invalid"));
    }

    @Test
    public void testGetStartedValid() {
        setMobileTest(false);
        SurveyPage s = new SurveyPage(driver);
        assertFalse(s.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@apio.tech", "testing123"));
    }

    @Test
    public void testGetStartedBlankPass() {
        setMobileTest(false);
        SurveyPage s = new SurveyPage(driver);
        assertTrue(s.businessSignUpTest("https://stageearlypay.apio.tech/login/#/new_account", "test@apio.tech", ""));
    }

    @Test
    public void testToLogin() {
        setMobileTest(false);
        SurveyPage s = new SurveyPage(driver);
        assertEquals(s.toLoginTest("https://stageearlypay.apio.tech/login/#/new_account"), "https://stageearlypay.apio.tech/login/#/");
    }

}
