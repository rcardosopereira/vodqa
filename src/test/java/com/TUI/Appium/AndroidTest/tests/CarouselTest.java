package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class CarouselTest extends TestBase {


    @Given("the user is on the carousel screen")
    public void the_user_is_on_the_carousel_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Demos swipe left & right\"]")).click();
        System.out.println("Carousel: Demos swipe left & right");
        //NEED TO CREATE THE TEST

        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

/*
        id yellow 00000000 - 0000 - 0474 - ffff - ffff000000cd
        var el1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]"));
        var el2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"2\"]"));
        var el3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3\"]"));

        String uiSelector1 = "new UiSelector().text(\"1\")";
        String uiSelector2 = "new UiSelector().text(\"2\")";
        String uiSelector3 = "new UiSelector().text(\"3\")";
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector3 + ")"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector2 + ")"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector1 + ")"));
        driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
 */
    }

    @Then("the user swipes left and right")
    public void the_user_swipes_left_and_right() {

    }

    @Then("the user should be able to view different items in the carousel")
    public void the_user_should_be_able_to_view_different_items_in_the_carousel() {

    }
}
