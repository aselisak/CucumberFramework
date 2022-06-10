Feature: Validation of login scenarios

  Background:
    #Given user is navigated to HRMS application

@batch12 @smoke @regression @sprint12 @latest
  Scenario: Admin login
    #Given user is navigated to HRMS application
     user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in

@regression @smoke @sprint12
  Scenario: ESS login
    #Given user is navigated to HRMS application
    When user enters valid ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

@regression  @smoke
  Scenario: Invalid login
    #Given user is navigated to HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then user see error message on the screen



 @regression @loginerror
   Scenario: Username cannot be empty
   When user enters empty username
   And user clicks on login button
   Then user see the error message username cannot be empty

 @regression @2525
   Scenario: Password cannot be empty
   When user enters  empty password
   And user clicks on login button
   Then user see the error message password cannot be empty


