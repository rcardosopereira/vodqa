package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


@Test
public class PhotoViewTest extends TestBase{

    @Given("the user is on the photo view screen")
    public void the_user_is_on_the_photo_view_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        // Navigate to the Photo View screen
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Ping & Zoom\"]")).click();
        System.out.println("Photo View: Ping & Zoom");

        // Perform swipe action
        performSwipe();

        // Verify elements on the Photos - Ping & Zoom screen
        Assert.assertNotNull(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Photos - Ping & Zoom\"]")));
        Assert.assertNotNull(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Photo Screen\"]")));
        Assert.assertNotNull(driver.findElement(AppiumBy.className("android.widget.ImageView")));
        Assert.assertNotNull(driver.findElement(AppiumBy.accessibilityId("photo")));

        // Additional assertions or verifications if needed

        // Example: Verify that the Photo Screen text is displayed
        WebElement photoScreenText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Photo Screen\"]"));
        Assert.assertTrue(photoScreenText.isDisplayed(), "Photo Screen text is not displayed");

        backButton();
    }

    @When("the user swipes left and right")
    public void the_user_swipes_left_and_right() {

    }

    @Then("the user should be able to view different photos")
    public void the_user_should_be_able_to_view_different_photos() {

    }
}
