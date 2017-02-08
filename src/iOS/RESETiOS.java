package iOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


//import org.openqa.selenium.remote.CapabilityType;


public class RESETiOS {
    IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "/Applications/STA/SeeTest-Trunk/bin/ipas/EriBankO.ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "f759ec5d8343175b2c68f856c9c47559aa1fc0fc");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.ExperiBankO");
//        capabilities.setCapability("noReset", true);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), (Capabilities) capabilities);
    }

    @Test
    public void restart() throws Exception {
//driver.launchApp();
//        installEribank();
        iOSLogin();
//        org.junit.Assert.assertEquals(true,doPayment());
////            driver.resetApp();
//        org.junit.Assert.assertEquals(true,chackForBalanceChange());

        Thread.sleep(1000);


    }

    @Ignore
    public void launch() throws Exception {
//        installEribank();
//        org.junit.Assert.assertEquals(true,doPayment());
        driver.launchApp();
//        org.junit.Assert.assertEquals(true,chackForBalanceChange());

        Thread.sleep(1000);
    }

    @Ignore
    public void close() throws Exception {
//        installEribank();
//        org.junit.Assert.assertEquals(true,doPayment());
        driver.close();
//        org.junit.Assert.assertEquals(true,chackForBalanceChange());
        Thread.sleep(1000);
    }


    @After
    public void teardown() {
        //close the app
        driver.quit();
    }

    boolean doPayment() throws InterruptedException {
        iOSLogin();
        Thread.sleep(1500);
        try {
            driver.findElement(By.xpath("//*[@text='Your balance is: \\n100.00$']"));
        } catch (Exception e) {
            System.err.println("Balance isn't 100$ at begging of test");
            return false;
        }
//     if (driver.findElement(By.xpath("//*[@contentDescription='Your balance is: 100.00$']")){
//         System.out.println("not clean at launch");
//         Assert.assertEquals(false,true);
//     }
        driver.findElement(By.name("makePaymentButton")).click();
        driver.findElement(By.name("countryButton")).click();
        driver.findElement(By.name("USA")).click();
        driver.findElement(By.name("phoneTextField")).sendKeys("654");
        driver.findElement(By.name("nameTextField")).sendKeys("sdfsd");
        driver.findElement(By.name("amountTextField")).sendKeys("500000");
        driver.hideKeyboard();
        driver.findElement(By.name("sendPaymentButton")).click();
        driver.findElement(By.name("Yes")).click();
        System.err.println("------------------payment was made------------------");
        return true;
    }

    boolean chackForBalanceChange() throws InterruptedException {
        iOSLogin();
        try {
            driver.findElement(By.xpath("//*[@text='Your balance is: \\n100.00$']"));
        } catch (Exception e) {
            System.err.println("Balance isn't 100$");
            return false;
        }
        System.err.println("-------------Balance 100$----------------");
        return true;
    }

    void installEribank() throws IOException {
        Runtime rt = Runtime.getRuntime();
//     rt.exec("d:");
        rt.exec("D:\\Users\\erez.akri.experitest\\AppData\\Local\\Android\\sdk\\platform-tools\\adb.exe uninstall com.experitest.ExperiBank");
        rt.exec("D:\\Users\\erez.akri.experitest\\AppData\\Local\\Android\\sdk\\platform-tools\\adb.exe install \"D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\EriBank.apk\"");
//     rt.exec("adb install \"D:\\Program Files (x86)\\Experitest\\SeeTest-Trunk\\bin\\ipas\\EriBank.apk\"");
    }

    void iOSLogin() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.name("usernameTextField")).sendKeys("company");
        driver.findElement(By.name("passwordTextField")).sendKeys("company");
        driver.findElement(By.name("loginButton")).click();
    }
}
