package com.example.christian.appiumruns;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.lang.InterruptedException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FirstTest {

    RemoteWebDriver driver;

    String apkpath="/Users/christian/Downloads/app-release.apk";
    File app=new File(apkpath);

    @Before
    public void setUp() {

        System.out.println("session is creating");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Google");
        //capabilities.setCapability(CapabilityType.VERSION, "7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.hellowo.day2life");
        capabilities.setCapability("appActivity", "com.day2life.timeblocks.activity.SplashActivity");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("noReset", "true");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("session is created");

        //String src = driver.getPageSource();
        //System.out.println(src);
    }

    @Test
    public void testFirstCalculator() throws InterruptedException{

        try {
            WebElement startButton = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("com.hellowo.day2life:id/memoBtn")));
            System.out.println("its there");
            startButton.click();
        } catch (Exception e) {
            System.out.println("couldn't find");
        }

        System.out.println("first test complete");

        Thread.sleep(5000);

    }

    @After
    public void end() {
        driver.quit();
        System.out.println("finished");
    }
}