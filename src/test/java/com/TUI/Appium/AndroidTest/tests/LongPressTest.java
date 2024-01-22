package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

@Test
public class LongPressTest extends TestBase{

    @Given("the user is on the long press screen")
    public void the_user_is_on_the_long_press_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Demo double tap button\"]")).click();
        System.out.println("Double Tap: Demo double tap buttom");

        // Find the element to double tap press
        WebElement elementToDoubleTap = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Double Tap Me\"]"));

        // Create a TouchAction instance
        TouchAction touchAction = new TouchAction(driver);

        // Perform double-tap action
        touchAction.tap(ElementOption.element(elementToDoubleTap))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(10)))
                .tap(ElementOption.element(elementToDoubleTap))
                .perform();

        // Unit Tests
        var doubleTapSuccess = driver.findElement(AppiumBy.id("android:id/message"));
        var doubleTap = driver.findElement(AppiumBy.id("android:id/alertTitle"));
        Assert.assertEquals(doubleTapSuccess.getText(), "Double tap successful!");
        Assert.assertEquals(doubleTap.getText(), "Double Tap");

        driver.findElement(AppiumBy.id("android:id/button1")).click();
        backButton();
    }

    @When("the user long presses on an element")
    public void the_user_long_presses_on_an_element() {
    }

    @Then("the long press should be successful")
    public void the_long_press_should_be_successful() {
    }
}
