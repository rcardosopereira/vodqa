package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@Test
public class VerticalSwipingTest extends TestBase {

    @Given("the user is on the vertical swiping screen")
    public void the_user_is_on_the_vertical_swiping_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Demos vertical swiping ']")).click();
        System.out.println("Vertical swiping: Demos vertical swiping");

    }

    @When("the user swipes down")
    public void the_user_swipes_down() {

        // Scroll Down
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Karma\"]")).click();
        // Unit Test
        var karma = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Karma\"]"));
        Assert.assertEquals(karma.getText(), " Karma");

    }

    @Then("the user should be able to view the Karma section")
    public void the_user_should_be_able_to_view_the_karma_section() {

    }

    @When("the user swipes up")
    public void the_user_swipes_up() {
        // Scroll Up
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollBackward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollBackward()"));

    }

    @Then("the user should be able to view the Javascript section")
    public void the_user_should_be_able_to_view_the_javascript_section() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Javascript\"]")).click();

        // Unit Test
        var javascript = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Javascript\"]"));
        Assert.assertEquals(javascript.getText(), " Javascript");

       // backButton();
    }
}
