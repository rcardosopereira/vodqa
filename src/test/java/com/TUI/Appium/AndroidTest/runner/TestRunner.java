package com.TUI.Appium.AndroidTest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.TUI.Appium.AndroidTest.tests")
public class TestRunner {
    // Leave this class empty
}


