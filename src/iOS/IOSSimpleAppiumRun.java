package iOS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.*;

public class IOSSimpleAppiumRun {

    //private static IOSDriver<WebElement> driver;
    private static IOSDriver<IOSElement> driver;
    final static String[] ERIBANK_PROP = {"EriBank.ipa", "com.experitest.ExperiBank", ".LoginActivity"};



    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "");
        File app = new File(appDir, ERIBANK_PROP[0]);
        //File app = new File(appDir, ERIBANK_PROP[0]);

        // To create an object of Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Name of mobile web browser to automate. It should be an empty string, as we are automation an app
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone");
        capabilities.setCapability("udid", "3e9b544065a89d2124822900206b4ab36de335c9");
        capabilities.setCapability("platformVersion", "10.1.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("bundleId", ERIBANK_PROP[1]);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("xcodeConfigFile", "/Users/erez.akri/Documents/untitled folder/appium-xcuitest--driver-master"
                + "/WebDriverAgent/Config.xcconfig");
        capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole/deviceconsole");

//		capabilities.setCapability("xcodeConfigFile", "/Users/Mac10/xcodeConfigFile");
        //capabilities.setCapability("appActivity", ERIBANK_PROP[2]);

        driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        //driver.findElementByXPath("//*[@id='usernameTextField']").sendKeys("company");
        //driver.findElement(By.name("usernameTextField")).sendKeys("company");
        //driver.findElement(By.name("passwordTextField")).sendKeys("company");
        //driver.findElement(By.name("loginButton")).click();
        List<IOSElement> findElementsByClassNameUITextFieldLabel = driver.findElementsByClassName("UITextFieldLabel");
        for (IOSElement element : findElementsByClassNameUITextFieldLabel) {
            element.sendKeys("company");
        }

        //	driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Username']")).sendKeys("company");
        //driver.findElementById("com.experitest.ExperiBank:id/usernameTextField").sendKeys("company");
        //driver.findElement(By.xpath("xpath=//*[@accessibilityLabel='Password']")).sendKeys("company");

        //driver.findElementByXPath("//*[@text='Login']").click();
        //System.out.println("Device Time : "+driver.getDeviceTime());
        System.out.println("Dump : \n" + driver.getPageSource());

        Thread.sleep(10000);
        driver.quit();

    }

}
