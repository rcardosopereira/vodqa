Feature: Android App Functionality Verification

  @nativeView
  Scenario: Verify elements in native view
    Given the user is on the main screen
    When the user navigates to the native view
    Then the user should see Hello World, I'm View one on the first view
    And the user should see Hello World, I'm View two on the second view
    And the user should see Hello World, I'm View three on the third view

  @slider
  Scenario: Verify user can interact with the slider
    Given the user is on the slider screen
    When the user slides the slider to 50percent or more
    Then the slider position should be at 50percent or more

  @verticalSwiping
  Scenario: Verify user can swipe vertically
    Given the user is on the vertical swiping screen
    When the user swipes down
    Then the user should be able to view the Karma section
    When the user swipes up
    Then the user should be able to view the Javascript section

  @dragAndDrop
  Scenario: Verify user can drag and drop elements
    Given the user is on the drag and drop screen
    When the user drags and drops the element to the target
    Then the element should be dropped successfully

  @doubleTap
  Scenario: Verify user can perform a double tap
    Given the user is on the double tap screen
    When the user double taps on an element
    Then the double tap should be successful

  @longPress
  Scenario: Verify user can perform a long press
    Given the user is on the long press screen
    When the user long presses on an element
    Then the long press should be successful

  @photoView
  Scenario: Verify user can navigate and view photos
    Given the user is on the photo view screen
    When the user swipes left and right
    Then the user should be able to view different photos

  @webView
  Scenario: Verify user can interact with a web view
    Given the user is on the web view screen
    When the user scrolls up and down
    Then the user should be able to interact with the web view

  @carousel
  Scenario: Verify user can navigate through the carousel
    Given the user is on the carousel screen
    When the user swipes left and right
    Then the user should be able to view different items in the carousel

  @wheelPicker
  Scenario: Verify user can select colors using a wheel picker
    Given the user is on the wheel picker screen
    When the user selects red from the wheel picker
    Then the selected color should be displayed as red
    And the user selects green from the wheel picker
    Then the selected color should be displayed as green
    And  the user selects blue from the wheel picker
    Then the selected color should be displayed as blue
    And  the user selects black from the wheel picker
    Then the selected color should be displayed as black
