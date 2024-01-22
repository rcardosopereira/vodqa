package com.TUI.Appium.AndroidTest.tests;

import com.TUI.Appium.AndroidTest.pages.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import com.TUI.Appium.AndroidTest.pages.DriverFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase extends DriverFactory {



    public static void setupApkOptions() throws MalformedURLException {
        DriverFactory.createDriver();
    }


    public static void tearDown() {
        DriverFactory.killDriver();
    }

    public void backButton() {
        WebElement backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    int calculateXCoordinate(WebElement seek, double percentage) {
        return (int) (seek.getLocation().getX() + (seek.getSize().getWidth() * percentage));
    }

    // Helper method to perform tap action at specified coordinates
    void performTapAction(int x, int y)  {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    void performSwipe() {
        // Find the initial and final elements for the swipe
        WebElement elementInicial = driver.findElement(AppiumBy.className("android.widget.ImageView"));
        WebElement elementFinal = driver.findElement(AppiumBy.className("android.widget.ImageView"));

        // Get the coordinates of the elements
        int startX = elementInicial.getLocation().getX() + elementInicial.getSize().getWidth() / 2;
        int startY = elementInicial.getLocation().getY() + elementInicial.getSize().getHeight() / 2;

        int endX = elementFinal.getLocation().getX() + elementFinal.getSize().getWidth() / 2;
        int endY = elementFinal.getLocation().getY() + elementFinal.getSize().getHeight() / 2;

        // Create a TouchAction object and perform the swipe
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}