package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DataGenerator;
import util.Helpers;

public class SupplierPortal {
    private WebDriver driver;
    private Helpers h;
    private DataGenerator d;

    public SupplierPortal(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        h = new Helpers(driver);
    }

    @FindBy(xpath="//a[contains(.,'Create Invoice')]")
    WebElement createInvoiceBtn;
    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement searchField;
    @FindBy(className="company-title-style")
    WebElement custList;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[1]/div/div/div[2]/p/input")
    WebElement invoiceNumber;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[1]/div/div/div[3]/p/div/div/span/select")
    WebElement netTerms;
    @FindBy(xpath="//option[@value='NET 30']")
    WebElement net30;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/table/tbody/tr[2]/td[5]/span/input")
    WebElement invoiceLine;
    @FindBy(xpath="//a[contains(.,'Continue')]")
    WebElement continueBtn;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[2]/div/article/div/div/div[1]/div[1]/p/input")
    WebElement itemName;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[2]/div/article/div/div/div[1]/div[2]/p/input")
    WebElement itemDescription;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[2]/div/article/div/div/div[2]/div[1]/p/input")
    WebElement itemQuantity;
    @FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div/div[1]/div[2]/div/article/div/div/div[2]/div[2]/div/div/input")
    WebElement itemPrice;
    @FindBy(xpath="//a[contains(.,'Add Line Item')]")
    WebElement addLineItemBtn;
    @FindBy(xpath="//a[contains(.,'Finish')]")
    WebElement finishBtn;
    @FindBy(xpath="//button[contains(.,'Skip Upload')]")
    WebElement skipBtn;





    public void newInvoice(String company, Integer lineAmount){
        h.scrollToAndClickElement(createInvoiceBtn, 0);
        searchField.sendKeys(company);
        h.scrollToAndClickElement((driver.findElement(By.xpath("//strong[contains(.,'"+company+"')]"))), 0);
        h.scrollToAndClickElement(createInvoiceBtn, 0);
        h.waitForElement(invoiceNumber);
        d = new DataGenerator();
        String vat = d.getCompanyVat();
        System.out.println(vat);
        invoiceNumber.sendKeys("Auto - " + vat );
        invoiceNumber.sendKeys(Keys.TAB);
        netTerms.sendKeys(Keys.ARROW_DOWN);
        itemName.sendKeys("Automation Item");
        itemDescription.sendKeys("Automation Description");
        itemQuantity.sendKeys("12");
        itemPrice.sendKeys("100");
        h.scrollToAndClickElement(addLineItemBtn, 0);
        h.scrollToAndClickElement(continueBtn,0);
        h.scrollToAndClickElement(finishBtn, 0);
        h.scrollToAndClickElement(skipBtn,0);
    }
}


