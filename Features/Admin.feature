Feature: Admin Tan Functionality test


  Background: Below are the common steps for every Scenario
    Given User Launch Chrome Browser
    When User Open Orange HRM
    And User Enter "Admin" As Admin Password As "admin123"
    And User Clicks On Login Button

  @sanity
  Scenario: User able to find system record search by username
    And User Click On Admin Tab
    And User Sets UserName linda.anderson
    And User Clicks On Search Button
    Then User Verify UserName linda.anderson displayed
    And User Close Browser

  @sanity
  Scenario Outline: User able to verify Job Tittles
    And User Click On Admin Tab
    And User Clicks On Job SubTittle
    And User Selects Job Tittles
    Then User Verify JobTitle <JobTittle> Exist
    And User Close Browser
    Examples:
      | JobTittle |
      | Manger    |
      | CEO       |
      | IT Manager|

    @sanity
    Scenario: User Able Add User in the System
      And User Click On Admin Tab
      And User Clicks Add Button
      And User Selects User Role ESS
      And User Types Employee Name Linda Anderson
      And User Types Username Linda
      And User Selects Status Enabled
      Then User Clicks on Save Button
      And User Verify Employee Name Created With Linda Anderson
      And User Close Browser
