package iOS;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class eribankRegularAuppium {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "/Applications/STA/SeeTest-Trunk/bin/ipas/EriBankO.ipa");
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("udid", "36f0a41a8fca9263c1f977b915dcb5668a0b83fc");
        capabilities.setCapability("deviceName", "Ipad");
        capabilities.setCapability("bundleId", "com.experitest.ExperiBankO");
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
    }

    @Test
    public void test() throws Exception {
//		System.out.println(driver.getPageSource());
        ArrayList<Long> iterationsTimeList = new ArrayList<Long>();
//        long startTime = System.currentTimeMillis();
        driver.closeApp();
        int i;
        for (i = 0; i < 10; i++) {
            long iteratioStartTime = System.currentTimeMillis();
            driver.launchApp();
            driver.findElement(By.name("usernameTextField")).clear();
            driver.findElement(By.name("usernameTextField")).sendKeys("company");
            driver.findElement(By.name("passwordTextField")).clear();
            driver.findElement(By.name("passwordTextField")).sendKeys("company");
            driver.findElement(By.name("loginButton")).click();
            driver.findElement(By.name("makePaymentButton")).click();
            driver.findElement(By.name("countryButton")).click();
            driver.findElement(By.name("Colombia")).click();
            driver.findElement(By.name("cancelButton")).click();
            driver.findElement(By.name("logoutButton")).click();
//        System.out.println(driver.getPageSource());
            driver.closeApp();
            long iteratioEndTime = System.currentTimeMillis();
            long iteratioTime = iteratioEndTime - iteratioStartTime;
            System.out.println("Iteration took: " + iteratioTime / 1000 + " seconds");
            iterationsTimeList.add(iteratioTime);

        }
//        long tottalTime = (System.currentTimeMillis() - startTime) / 1000;
        long totalrunningTime = iterationsTimeList.stream().mapToLong(Long::longValue).sum() / 1000;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(this.getClass().getName());
        System.out.println(i + " itarations took " + totalrunningTime + " seconds");
        System.out.println("avarage time per iteration was: " + (totalrunningTime / i) + " seconds");
        System.out.println("----------------------------------------------------------------------------------");

    }

}