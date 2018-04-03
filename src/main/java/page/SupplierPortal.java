package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Helpers;

public class SupplierPortal {
    private WebDriver driver;
    private Helpers h;

    @FindBy(xpath="//button[contains(.,'Create Invoice')]\")")
    WebElement createInvoice;
}


