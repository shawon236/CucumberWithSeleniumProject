Feature: LoginTest

  @Regression
  Scenario: User Able To Login Application
    Given User Launch Chrome Browser
    When User Open Orange HRM
    And User Enter "Admin" As Admin Password As "admin123"
    And User Clicks On Login Button
    Then User Verify "Welcome" Text
    And User Logout From Application
    And User Close Browser

    @Regression
    Scenario Outline: Login with correct user name and password
      Given User Launch Chrome Browser
      When User Open Orange HRM
      And User  Enter <userName> And <password>
      And User Clicks On Login Button
      Then User Verify "Welcome" Text
      And User Click On "PIM" Type "Link"
      And User Search Employee By Name "Linda"
      And User Sees FirstName "Linda" displayed
      And User Close Browser
      Examples:
      |userName|password|
      |Admin   |admin123|
