package com.TUI.Appium.AndroidTest.pages;

import com.TUI.Appium.AndroidTest.tests.TestBase;
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

public class DriverFactory{
    protected static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void createDriver() throws MalformedURLException {

        System.out.println("-----------------------Started: VODQA APk-----------------------");

        // String apkPath = "C:\\Rafael\\Projects\\Android\\MobileChallenge\\MobileQA\\src\\test\\resources\\appiumChallenge.apk";
        //ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource("src/test/resources/appiumChallenge.apk").getFile());
        //String apkPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android")
                .setDeviceName("emulator")
                .setAppPackage("com.vodqareactnative")
                .setAppActivity("com.vodqareactnative.MainActivity")
                //options.setCapability("appium:deviceScreenSize", "1080x2280"); //APK File
                //options.setApp(apkPath); //Optional, Drag and Drop can also be used
                //options.setNoReset(false); //Optional, true: Will not install app if its present
                .setAutoGrantPermissions(true) //Optional, Enables automatic granting of permissions.
                .setNewCommandTimeout(Duration.ofSeconds(11));

        try {
            System.out.println("-----------------------Run Started-----------------------");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Thread.sleep(4000);

        //"Files and media" [button]
        driver.findElement(AppiumBy.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[1]")).click();

        //This app was designed for an older version of Android. Denying permission my cause it to no longer function as intended.
        //"Deny anyway" [button]
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        //"Phone" [button]
        driver.findElement(AppiumBy.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[2]")).click();

        //"Notifications" [button]:Only for physical device mobile
        //driver.findElement(AppiumBy.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[3]")).click();

        //"Photos and videos" [button]:Only for physical device mobile
        //driver.findElement(AppiumBy.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[4]")).click();

        //"Music and audio" [button]:Only for physical device mobile
        //driver.findElement(AppiumBy.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[5]")).click();

        //Choose what to Allow VodQAReactNative to access:
        //"Continue" [button]
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();

        //VodQAReactNative :
        //This app was built for an older version of Android and may not work properly. Try checking for updates, or contact the developer.
        //"OK" [button]
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        Dimension size = driver.manage().window().getSize();

        System.out.println("Screen Width: " + screenWidth);
        System.out.println("Screen Height: " + screenHeight);
        System.out.println("Screen Dimension: " + size);


        //Unit Tests
      //  var userName = driver.findElement(AppiumBy.accessibilityId("username"));
      //  Assert.assertEquals("admin", userName.getText());
        //var userPass = driver.findElement(AppiumBy.accessibilityId("password"));
        //Assert.assertEquals("admin", userPass.getText());

        //String passwordValue = userPass.getAttribute("value");
        //System.out.println("Senha: " + passwordValue);
        //String passwordValue = userPass.getAttribute("value");
        //System.out.println("Senha: " + passwordValue);
        //Assert.assertEquals("admin", passwordValue);

        //"LOG IN" [button]
     //   driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOG IN\"]")).click();
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

