package iOS;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clander {
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws Exception {
// set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "cbc20b1088c65f4a27dca70b158843f69f249a64");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("app", "com.united.UnitedCustomerFacingIPhone");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void getdump() {
        driver.getPageSource();
    }


}
