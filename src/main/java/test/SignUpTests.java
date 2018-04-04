package test;

import base.TestBase;
import org.testng.annotations.Test;
import page.SignUpPage;
import util.DataGenerator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SignUpTests extends TestBase {

    // Sign Up Page Tests
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

}
