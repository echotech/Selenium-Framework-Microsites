package test;

import base.TestBase;
import org.testng.annotations.Test;
import page.LoginPage;
import static org.testng.Assert.assertEquals;

public class Tests extends TestBase {

    //Login Page Tests
    @Test(groups = {"smoke", "login"})
    public void testLoginInvalidBoth(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@test.com", "test1"), true);
    }

    @Test(groups = {"smoke", "login"})
    public void testLoginInvalidUser(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","invalid@test.com", "testing123"), true);
    }

    @Test(groups = {"smoke", "login"})
    public void testLoginInvalidPass(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", "invalid"), true);
    }

    @Test(groups = {"smoke", "login"})
    public void testLoginValid(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", "testing123"), false);
    }

    @Test(groups = {"smoke", "login"})
    public void testBlankPass(){
        setMobileTest(false);
        LoginPage l = new LoginPage(driver);
        assertEquals(l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", ""), true);
    }

}
