package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    private WebDriver driver;

    public Helpers(WebDriver driver){
        this.driver=driver;
    }

    //Helper methods
    public void scrollToAndClickElement(WebElement element, int offset) {
        try {
            waitForElement(element);
            Actions act = new Actions(driver);
            act.moveToElement(element).click().perform();
            //System.out.println("Clicked "+ element.getText());

        } catch (Exception e) {
            System.out.println("Unable to locate element " + element.getText() + ".");
            e.printStackTrace();
        }
    }

    public void waitForElement(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }
}
