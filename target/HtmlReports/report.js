$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Admin.feature");
formatter.feature({
  "name": "Admin Tan Functionality test",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Below are the common steps for every Scenario",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.user_Launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Open Orange HRM",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.user_Open_Orange_HRM()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enter \"Admin\" As Admin Password As \"admin123\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userEnterAsAdminPasswordAs(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicks On Login Button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userClicksOnLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User Able Add User in the System",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "User Click On Admin Tab",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userClickOnAdminTab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicks Add Button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userClicksAddButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Selects User Role ESS",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userSelectsUserRole(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Types Employee Name Linda Anderson",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userTypesEmployeeName(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Types Username Linda",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userTypesUsername(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Selects Status Enabled",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userSelectsStatus(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Clicks on Save Button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userClicksOnSaveButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Verify Employee Name Created With Linda Anderson",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.userVerifyEmployeeNameCreated(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Close Browser",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.HRMSteps.user_Close_Browser()"
});
formatter.result({
  "status": "passed"
});
});