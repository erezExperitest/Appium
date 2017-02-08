package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by erez.akri on 2/7/17.
 */
public class tapclick {

    IOSDriver driver;


    @Before
    public void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "/Applications/STA/SeeTest-Trunk/bin/ipas/EriBank.ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "60ab9979d3fbef1c2692ac9b2b0aa766cb3efb44");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.ExperiBank");
//        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET,true);
//        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities) capabilities);
    }

    @Test
    public void tapTest() {
        driver.findElement(By.name("usernameTextField")).sendKeys("company");
        driver.findElement(By.name("passwordTextField")).sendKeys("company");
//        driver.tap(1, driver.findElement(By.name("loginButton")), 200);
        System.out.println(driver.findElement(By.name("loginButton")).getText());

    }

    @After
    public void end() {
        driver.quit();
    }
}
