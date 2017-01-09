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

public class AppiumTest {
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws Exception {
// set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "6.1");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
        capabilities.setCapability("app","/Users/username/Downloads/InternationalMountains/build/Release-iphonesimulator/InternationalMountains.app");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//window[1]/tableview[1]/cell[2]")).click();
        driver.findElement(By.xpath("//window[1]/navigationBar[1]/button[1]")).click();
        driver.findElement(By.xpath("//window[1]/tableview[1]/cell[7]/text[1]")).click();
    }
}