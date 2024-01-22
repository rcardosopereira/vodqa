package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;


public class WheelPickerTest extends TestBase {

    @Given("the user is on the wheel picker screen")
    public void the_user_is_on_the_wheel_picker_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Demos wheel picker color\"]")).click();
        System.out.println("Wheel Picker: Demos wheel picker color");

        driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"red\"]")).click();
        var red = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Current Color: red \"]"));
        Assert.assertTrue(red.getText().contains("red"), "Selected color is not red");

        driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"green\"]")).click();
        var green = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Current Color: green \"]"));
        Assert.assertTrue(green.getText().contains("green"), "Selected color is not green");

        driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"blue\"]")).click();
        var blue = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Current Color: blue \"]"));
        Assert.assertTrue(blue.getText().contains("blue"), "Selected color is not blue");

        driver.findElement(AppiumBy.className("android.widget.Spinner")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"black\"]")).click();
        var black = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Current Color: black \"]"));
        Assert.assertTrue(black.getText().contains("black"), "Selected color is not black");
    }

    @When("the user selects red from the wheel picker")
    public void the_user_selects_red_from_the_wheel_picker() {
    }

    @Then("the selected color should be displayed as red")
    public void the_selected_color_should_be_displayed_as_red() {
    }

    @When("the user selects green from the wheel picker")
    public void the_user_selects_green_from_the_wheel_picker() {
    }

    @Then("the selected color should be displayed as green")
    public void the_selected_color_should_be_displayed_as_green() {
    }


    @When("the user selects blue from the wheel picker")
    public void the_user_selects_blue_from_the_wheel_picker() {
    }

    @Then("the selected color should be displayed as blue")
    public void the_selected_color_should_be_displayed_as_blue() {
    }


    @When("the user selects black from the wheel picker")
    public void the_user_selects_black_from_the_wheel_picker() {
    }

    @Then("the selected color should be displayed as black")
    public void the_selected_color_should_be_displayed_as_black() {
    }


}


