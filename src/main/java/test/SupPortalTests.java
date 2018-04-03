package test;

import base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.SupplierPortal;
import util.DataGenerator;

import static org.testng.Assert.assertEquals;

public class SupPortalTests extends TestBase{

    @Test
    public void newInvoiceClean(){
        LoginPage l = new LoginPage(driver);
        l.loginTest("https://stageearlypay.apio.tech/login/","test@apio.tech", "testing123");
        SupplierPortal s = new SupplierPortal(driver);
        s.newInvoice();

    }
}
