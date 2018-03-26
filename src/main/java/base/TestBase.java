package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 11/15/2017.
 */
public class TestBase {
    protected static WebDriver driver;
    public boolean mobileTest;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/drivers/chromedriver.exe");
    }

    public void setMobileTest(boolean mobile){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        mobileTest=mobile;

        //Mobile Emulation
        String deviceName = "Galaxy S5";
        Map<String, String> devices =  new HashMap<>();
        devices.put("deviceName", deviceName);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("mobileEmulation", devices);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, mobileEmulation);

        //Headless
        //options.addArguments("headless");

        if(mobileTest){
            //capabilities.setCapability();
            driver = new ChromeDriver(capabilities);
            System.out.println("Mobile emulation testing for "+deviceName);
        } else {
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        //Close all tabs
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();

        }
    }
}
