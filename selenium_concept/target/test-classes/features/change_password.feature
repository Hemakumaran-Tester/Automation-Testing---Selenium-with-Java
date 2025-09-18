Feature: Change Password Functionality

  Scenario: Change Password
    Given checking landing page and buttons
    When update with invalid current password
    And update with valid password
    Then login with new password