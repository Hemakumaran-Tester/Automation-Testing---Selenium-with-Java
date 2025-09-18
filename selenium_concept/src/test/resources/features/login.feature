Feature: Login Functionality

  Scenario: Login page
    Given Open Application
    When Login without credentials
     And Login with invalid credentials
    Then Login with valid credentials