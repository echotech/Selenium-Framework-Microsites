package test;

import base.TestBase;
import io.codearte.jfairy.producer.company.Company;
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

}
