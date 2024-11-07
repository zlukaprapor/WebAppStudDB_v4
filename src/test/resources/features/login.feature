Feature: User Authorization
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid email "user@example.com" and password "password123"
    And clicks the login button
    Then the user should be redirected to the home page

