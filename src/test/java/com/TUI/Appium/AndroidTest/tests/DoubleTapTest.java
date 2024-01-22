package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MultiTouchAction;
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
public class DoubleTapTest extends TestBase {


    @Given("the user is on the double tap screen")
    public void the_user_is_on_the_double_tap_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Demo drag and drop\"]")).click();
        System.out.println("Drag and Drop: Demo drag and drop");

        WebElement drag = driver.findElement(AppiumBy.accessibilityId("dragMe"));
        WebElement drop = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Drop here.\"]"));

        TouchAction action = new TouchAction(driver);

        action.longPress(ElementOption.element(drag))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))) //Comment on this line to drag the movement slower
                .moveTo(ElementOption.element(drop))
                .release()
                .perform();

        //Perform drag and drag action
        MultiTouchAction multiAction = new MultiTouchAction(driver);
        multiAction.add(action).perform();


        // Unit Tests
        var circleDroppedID = driver.findElement(AppiumBy.accessibilityId("success")); //circle dropped
        var circleDroppedXPath = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Circle dropped\"]"));
        Assert.assertEquals(circleDroppedID.getText(), "Circle dropped");
        Assert.assertEquals(circleDroppedXPath.getText(), "Circle dropped");
    }

    @When("the user double taps on an element")
    public void the_user_double_taps_on_an_element() {

    }

    @Then("the double tap should be successful")
    public void the_double_tap_should_be_successful() {

    }


}







