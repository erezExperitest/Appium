package iOS;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.SwipeElementDirection.DOWN;
import static io.appium.java_client.SwipeElementDirection.UP;


//import org.openqa.selenium.remote.CapabilityType;


public class getpagesource {
    AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "/Users/erez.akri/Downloads/UICatalog (2).ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.UICatalog");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET,true);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities) capabilities);
    }


    @Test
    public void getsource() throws FileNotFoundException {
        clickGtsourceBack("Buttons");
        clickGtsourceBack("Controls");
        clickGtsourceBack("TextFields");
        clickGtsourceBack("SearchBar");
        clickGtsourceBack("TextView");
        clickGtsourceBack("Pickers");
        clickGtsourceBack("Images");
        clickGtsourceBack("Web");
        clickGtsourceBack("Map");
        clickGtsourceBack("GLKit");
        clickGtsourceBack("Segment");
        clickGtsourceBack("Toolbar");
        clickGtsourceBack("Alerts");
        clickGtsourceBack("Transitions");
//        driver.findElement(By.name("Transitions")).swipe(DOWN,15000);
        clickGtsourceBack("Authentication");
        clickGtsourceBack("CameraAVTitle");
        clickGtsourceBack("PhotoPickerViewTitle");
        clickGtsourceBack("SFSafariViewControllerTitle");
    }

    @After
    public void teardown() {
        //close the app
        driver.quit();
    }

    public void clickGtsourceBack(String section) throws FileNotFoundException {
        driver.findElement(By.name(section)).click();
        PrintWriter out = new PrintWriter("UICatalog " + section + ".xml");
        out.println(driver.getPageSource());
        out.close();
//        if (section == "PhotoPickerViewTitle" )
//            driver.findElement(By.name("Cancel")).click();
//        else if (section == "SFSafariViewControllerTitle" )
//            driver.findElement(By.name("Done")).click();
//        else
        driver.findElement(By.name("Back")).click();

    }
}