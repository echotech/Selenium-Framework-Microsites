package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;

public class SupplierPortal {
    private WebDriver driver;
    private Helpers h;

    public SupplierPortal(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        h = new Helpers(driver);
    }

    @FindBy(xpath="//a[contains(.,'Create Invoice')]")
    WebElement createInvoiceBtn;

    public void newInvoice(){
        h.scrollToAndClickElement(createInvoiceBtn, 0);

    }
}


