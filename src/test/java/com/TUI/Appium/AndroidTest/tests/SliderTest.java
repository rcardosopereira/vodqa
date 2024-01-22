package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.net.MalformedURLException;


public class SliderTest extends TestBase {

    @Given("the user is on the slider screen")
    public void the_user_is_on_the_slider_screen() throws MalformedURLException {
        setupApkOptions();

        //"LOG IN" [button]
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Slide your number']")).click();
        System.out.println("Slider: Slide your number");
    }

    @When("the user slides the slider to 50percent or more")
    public void the_user_slides_the_slider_to_50percent_or_more() {

        // Find the slider element
        WebElement seek = driver.findElement(new AppiumBy.ByAccessibilityId("slider"));

        // Calculate the Y coordinate
        int y = seek.getLocation().getY() + (seek.getSize().getHeight() / 2);
        System.out.println("Slider Y Coordinate: " + y);

        // Define percentages for different positions
        double p50 = 0.5;
        double p99 = 0.99;
        double p0 = 0;

        // Calculate X coordinates for different positions
        int x50 = calculateXCoordinate(seek, p50);
        int x99 = calculateXCoordinate(seek, p99);
        int x0 = calculateXCoordinate(seek, p0);

        // Perform touch actions
        performTapAction(x99, y);
        performTapAction(x50, y);
        performTapAction(x0, y);

        // Convert the integer to a string
        String yAsString = String.valueOf(y);
        // Perform the assertion
        Assert.assertEquals(yAsString, "442");

        backButton();
    }

    @Then("the slider position should be at 50percent or more")
    public void the_slider_position_should_be_at_50percent_or_more() {

    }
}


