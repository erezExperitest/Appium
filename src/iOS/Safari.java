package iOS;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class Safari {
    private AppiumDriver driver;
    //    private final String UDID = "36f0a41a8fca9263c1f977b915dcb5668a0b83fc";
    private Process webkitProcess;
    static ThreadLocal<String> UDID = new ThreadLocal<>();


    @Before
    public void setUp() throws Exception {
//        webkitProcess = startWebKit(UDID);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", UDID.get());
        capabilities.setCapability("deviceName", "Ipad");
//        capabilities.setCapability("bundleId", "com.apple.Preferences");
//        capabilities.setCapability("bundleId", "com.apple.mobilesafari");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.SAFARI);
//        capabilities.setCapability("browser","safari");

        capabilities.setCapability("noReset", true);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole");
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities) capabilities);

    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        webkitProcess.destroy();
    }


    @Test
    public void googleImage() {

        driver.get("http://www.wikipedia.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getPageSource());
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).sendKeys("experitest");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.RETURN);
//        driver.getClient().sendText("{ENTER}");

//        if (driver.getClient().waitForElement("WEB", "text=תמונות", 0, 30000)) {
//            // If statement
//        }
        driver.findElement(By.linkText("תמונות")).click();
        driver.findElement(By.xpath("//*[@name='1tqX0q1YsulfuM:']")).click();
    }

    void swipeUp() {
        //Get the size of screen.
        Dimension size = driver.manage().window().getSize();
//        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.70);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.30);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
//        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top.
        driver.swipe(startx, starty, startx, endy, 3000);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void swipeDown() {
        //Get the size of screen.
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);


        //Swipe from Top to Bottom.
        driver.swipe(startx, endy, startx, starty, 3000);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Process startWebKit(String udid) {
        final String command = "ios_webkit_debug_proxy -c " + udid + ":27753";
        System.out.println("executing shell command:\n" + command);
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            p.waitFor();
            StringBuffer output = new StringBuffer();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            try {
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return p;
    }
}