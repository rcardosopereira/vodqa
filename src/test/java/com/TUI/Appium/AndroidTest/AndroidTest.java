package com.TUI.Appium.AndroidTest;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;


public class AndroidTest {
    public static AndroidDriver driver;
    //public static AppiumDriver driver;

    @BeforeClass
    public void setupApkOptions() throws MalformedURLException {
        System.out.println("-----------------------Started: VODQA APk-----------------------");

        // String apkPath = "C:\\Rafael\\Projects\\Android\\MobileChallenge\\MobileQA\\src\\test\\resources\\appiumChallenge.apk";
        //ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource("src/test/resources/appiumChallenge.apk").getFile());
        //String apkPath = file.getAbsolutePath();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator");
        options.setAppPackage("com.vodqareactnative");
        options.setAppActivity("com.vodqareactnative.MainActivity");
        //options.setCapability("appium:deviceScreenSize", "1080x2280"); //APK File
        //options.setApp(apkPath); //Optional, Drag and Drop can also be used
        //options.setNoReset(false); //Optional, true: Will not install app if its present
        options.setAutoGrantPermissions(true); //Optional, Enables automatic granting of permissions.
        options.setNewCommandTimeout(Duration.ofSeconds(11));

        System.out.println("-----------------------Run Started-----------------------");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
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

    @AfterClass
    public void tearDown() {
        driver.quit();

        //if (service.isRunning() == true){
        //    service.stop();
        //    System.out.println("Appium Server Stop...");
        //}

    }

    @Test(priority = 1)
    public void nativeViewTest() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"chainedView\"]")).click();
        System.out.println("Native View/Chained View");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        var el6 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View one \"]"));
        Assert.assertEquals("Hello World, I'm View one ", el6.getText());
        el6.click();
        System.out.println(el6.getText());

        var el7 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View two \"]"));
        Assert.assertEquals("Hello World, I'm View two ", el7.getText());
        el7.click();
        System.out.println(el7.getText());

        var el8 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"textView\" and @text=\"Hello World, I'm View three \"]"));
        Assert.assertEquals("Hello World, I'm View three ", el8.getText());
        el8.click();
        System.out.println(el8.getText());

        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void sliderTest() {
        // Click on the element
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Slide your number']")).click();
        System.out.println("Slider: Slide your number");

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

        navigateBack();
    }

    // Helper method to calculate X coordinate based on percentage
    private int calculateXCoordinate(WebElement seek, double percentage) {
        return (int) (seek.getLocation().getX() + (seek.getSize().getWidth() * percentage));
    }

    // Helper method to perform tap action at specified coordinates
    private void performTapAction(int x, int y) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    private void navigateBack() {
        WebElement backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 3)
    public void verticalSwipingTest() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Demos vertical swiping ']")).click();
        System.out.println("Vertical swiping: Demos vertical swiping");

        // Scroll Down
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Karma\"]")).click();

        // Unit Test
        var karma = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Karma\"]"));
        Assert.assertEquals(karma.getText(), " Karma");

        // Scroll Up
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollBackward()"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollBackward()"));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Javascript\"]")).click();

        // Unit Test
        var javascript = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Javascript\"]"));
        Assert.assertEquals(javascript.getText(), " Javascript");

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 4)
    public void dragAndDropTest() throws InterruptedException {
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

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 5)
    public void doubleTapTest() throws InterruptedException {
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

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 6)
    public void longPressTest() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Demo Long press button\"]")).click();
        System.out.println("Long Press: Demo Long press button");

        // Unit Tests
        WebElement longPressElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Long press the Botton\"]"));
        Assert.assertTrue(longPressElement.getText().contains("Long press the Botton"));
        Assert.assertNotNull(longPressElement, "Element with text 'Long press the Botton' not found");
        Assert.assertEquals(longPressElement.getText(), "Long press the Botton", "Incorrect text");
        Assert.assertTrue(longPressElement.isDisplayed(), "Element is not displayed");

        // Find the element to long press
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Long Press Me']"));

        // Create a TouchAction object
        TouchAction touchAction = new TouchAction(driver);

        // Perform a long press on the element
        touchAction.longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();

        // Unit Tests
        var pressedHard = driver.findElement(By.xpath("//android.widget.TextView[@text='you pressed me hard :P']"));
        var longPressed = driver.findElement(By.xpath("//android.widget.TextView[@text='Long Pressed']"));
        Assert.assertEquals(pressedHard.getText(), "you pressed me hard :P");
        Assert.assertEquals(longPressed.getText(), "Long Pressed");

        driver.findElement(AppiumBy.id("android:id/button1")).click();

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 7)
    public void verifyPhotoView() throws InterruptedException {
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

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void performSwipe() {
        // Find the initial and final elements for the swipe
        WebElement elementInicial = driver.findElement(AppiumBy.className("android.widget.ImageView"));
        WebElement elementFinal = driver.findElement(AppiumBy.className("android.widget.ImageView"));

        // Get the coordinates of the elements
        int startX = elementInicial.getLocation().getX() + elementInicial.getSize().getWidth() / 2;
        int startY = elementInicial.getLocation().getY() + elementInicial.getSize().getHeight() / 2;

        int endX = elementFinal.getLocation().getX() + elementFinal.getSize().getWidth() / 2;
        int endY = elementFinal.getLocation().getY() + elementFinal.getSize().getHeight() / 2;

        // Create a TouchAction object and perform the swipe
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    @Test(priority = 8)
    public void webViewTest() throws InterruptedException {
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

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 9)
    public void carouselTest() throws InterruptedException {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollForward()"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Demos swipe left & right\"]")).click();
        System.out.println("Carousel: Demos swipe left & right");
        //NEED TO CREATE THE TEST
        Thread.sleep(1000);
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

    @Test(priority = 10)
    public void wheelPickerTest() throws InterruptedException {
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

        Thread.sleep(1000);
        var backButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Back\"]"));
        backButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
