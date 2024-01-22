package com.TUI.Appium.AndroidTest.tests;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class NativeViewTest extends TestBase {

   @Given("the user is on the main screen")
   public void the_user_is_on_the_main_screen() throws MalformedURLException {
      setupApkOptions();

      //Unit Tests
      var userName = driver.findElement(AppiumBy.accessibilityId("username"));
      Assert.assertEquals("admin", userName.getText());
      //var userPass = driver.findElement(AppiumBy.accessibilityId("password"));
      //Assert.assertEquals("admin", userPass.getText());

      //String passwordValue = userPass.getAttribute("value");
      //System.out.println("Senha: " + passwordValue);
      //String passwordValue = userPass.getAttribute("value");
      //System.out.println("Senha: " + passwordValue);
      //Assert.assertEquals("admin", passwordValue);

      //"LOG IN" [button]
      driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();
   }

   @When("the user navigates to the native view")
   public void the_user_navigates_to_the_native_view() {
      driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"chainedView\"]")).click();
      System.out.println("Native View/Chained View");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

   @Then("the user should see Hello World, I'm View one on the first view")
   public void the_user_should_see_on_the_first_view() {
      var oneView = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View one \"]"));
      Assert.assertEquals("Hello World, I'm View one ", oneView.getText());
      oneView.click();
      System.out.println(oneView.getText());
   }

   @Then("the user should see Hello World, I'm View two on the second view")
   public void the_user_should_see_on_the_second_view() {
      var twoView = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View two \"]"));
      Assert.assertEquals("Hello World, I'm View two ", twoView.getText());
      twoView.click();
      System.out.println(twoView.getText());
   }

   @Then("the user should see Hello World, I'm View three on the third view")
   public void the_user_should_see_on_the_third_view() throws MalformedURLException {
      {
         var threeView = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View three \"]"));
         Assert.assertEquals("Hello World, I'm View three ", threeView.getText());
         threeView.click();
         System.out.println(threeView.getText());
         backButton();
      }
   }
}