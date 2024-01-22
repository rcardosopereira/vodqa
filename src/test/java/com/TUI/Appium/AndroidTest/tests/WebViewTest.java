package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;

public class WebViewTest extends TestBase {

    @Given("the user is on the web view screen")
    public void the_user_is_on_the_web_view_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"View hacker news\"]")).click();
        System.out.println("Web View: View hacker news");

        //Scroll down
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));

        //Scroll up
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollBackward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollBackward()"));

        WebElement textViewElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Webview']"));
        Assert.assertEquals("Webview", textViewElement.getText());
        Assert.assertTrue(textViewElement.getText().contains("Webview"));

        backButton();

    }

    @When("the user scrolls up and down")
    public void the_user_scrolls_up_and_down() {

    }

    @Then("the user should be able to interact with the web view")
    public void the_user_should_be_able_to_interact_with_the_web_view() {

    }


}
