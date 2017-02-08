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
//        capabilities.setCapability("app", "/Users/erez.akri/Downloads/UICatalog (2).ipa");
        capabilities.setCapability("platformName", "IOS");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
        capabilities.setCapability("app", "/Applications/STA/SeeTest-Trunk/bin/ipas/Browser.ipa");
        capabilities.setCapability("udid", "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        capabilities.setCapability("deviceName", "Ipad");
//        capabilities.setCapability("bundleId", "com.experitest.UICatalog");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET,true);
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities) capabilities);
    }


    @Test
    public void getsource() throws FileNotFoundException, InterruptedException {
        //iOSLogin();
        //System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@value='Go to this address']")).sendKeys("www.google.com");
        driver.findElement(By.xpath("//*[@name='Go']")).click();
        Thread.sleep(5000);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        PrintWriter out = new PrintWriter("Browser instrumented balance page.xml");
        out.println(pageSource);
        out.close();

        String substring = "dom=\"\"";

        int count = getCount(pageSource, substring);
        System.out.println("Number of times dom= \"\" is " + count);
//        driver.get("ynet.com")
        count = getCount(pageSource, "dom=");
        System.out.println("Number of times dom= is " + count);


    }

    private int getCount(String pageSource, String substring) {
        int lastindex = 0;
        int count = 0;
        while (lastindex != -1) {
            lastindex = pageSource.indexOf(substring, lastindex);
            if (lastindex != -1) {
                count++;
                lastindex += substring.length();

            }
        }
        return count;
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

    void iOSLogin() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.name("usernameTextField")).sendKeys("company");
        driver.findElement(By.name("passwordTextField")).sendKeys("company");
        driver.findElement(By.name("loginButton")).click();
    }
}