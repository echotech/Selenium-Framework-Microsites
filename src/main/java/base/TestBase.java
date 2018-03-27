package base;


import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 11/15/2017.
 */
public class TestBase {
    protected static WebDriver driver;
    public boolean mobileTest;
    public String CHROME_DRIVER_PATH;

    @BeforeSuite
    public void init() {
        setChromeDriverPath();
        setWebDriver();
    }

    private void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        options.addArguments("chrome.switches","--disable-extensions"); //Removes popup reminder for disabling extensions

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        options.merge(capabilities);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public void setChromeDriverPath(){
        String OS = System.getProperty("os.name").toLowerCase();

        if(OS.contains("win")){
            CHROME_DRIVER_PATH="./src/main/java/resources/drivers/chromedriver.exe";
        }
        if(OS.contains("mac")){
            CHROME_DRIVER_PATH="./src/main/java/resources/drivers/chromedriver_mac";
        }
        if(OS.contains("nix")||OS.contains("nux")||OS.contains("aix")){
            CHROME_DRIVER_PATH="./src/main/java/resources/drivers/chromedriver_nux";
        }
    }

    public void setMobileTest(boolean mobile) {
        ChromeOptions options = new ChromeOptions();
        mobileTest = mobile;

        //Mobile Emulation
        String deviceName = "Galaxy S5";
        Map<String, String> devices = new HashMap<>();
        devices.put("deviceName", deviceName);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("mobileEmulation", devices);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, mobileEmulation);

        if (mobileTest) {
            //capabilities.setCapability();
            options.merge(capabilities);
            driver = new ChromeDriver(options);
            System.out.println("Mobile emulation testing for " + deviceName);
        }
    }

    public void setHeadless(boolean headless){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        if(headless){
            //Headless
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        System.out.println("Closing windows.");
        Thread.sleep(1000);
        //Close all tabs
        driver.quit();
    }
}
